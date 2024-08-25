package com.sparta.schedule2.service;

import com.sparta.schedule2.dto.*;
import com.sparta.schedule2.entity.Schedule;
import com.sparta.schedule2.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    @Transactional
    public ScheduleSaveResponseDto saveSchedule(ScheduleSaveRequestDto requestDto) {
        Schedule newSchedule = new Schedule(requestDto.getUsername(), requestDto.getTitle(), requestDto.getDescription());
        Schedule savedSchedule = scheduleRepository.save(newSchedule);

        return new ScheduleSaveResponseDto(savedSchedule.getId(), savedSchedule.getUsername(),
                savedSchedule.getTitle(), savedSchedule.getDescription(),
                savedSchedule.getCreatedDate(), savedSchedule.getModifiedDate());
    }

    public ScheduleDetailResponseDto getSchedule(Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new NullPointerException("해당 ID를 가진 할일이 존재하지 않습니다."));

        return new ScheduleDetailResponseDto(schedule.getId(), schedule.getUsername(), schedule.getTitle(),
                schedule.getDescription(), schedule.getCreatedDate(), schedule.getModifiedDate());
    }

    @Transactional
    public ScheduleUpdateResponseDto updateSchedule(Long scheduleId, ScheduleUpdateRequestDto requestDto) {
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new NullPointerException("해당 ID를 가진 할일이 존재하지 않습니다."));

        schedule.update(requestDto.getUsername(), requestDto.getTitle(), requestDto.getDescription());
        return new ScheduleUpdateResponseDto(schedule.getId(), schedule.getUsername(),
                schedule.getTitle(), schedule.getDescription(), schedule.getCreatedDate(), schedule.getModifiedDate());
    }

    public List<SchedulePageResponseDto> getSchedules(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.DESC, "modifiedDate"));
        Page<SchedulePageResponseDto> page = scheduleRepository.findAll(pageable)
                .map(SchedulePageResponseDto::from);
        return page.getContent();
    }
}
