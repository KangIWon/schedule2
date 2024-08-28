package com.sparta.schedule2.service;

import com.sparta.schedule2.dto.schedule.requestDto.ScheduleSaveRequestDto;
import com.sparta.schedule2.dto.schedule.requestDto.ScheduleUpdateRequestDto;
import com.sparta.schedule2.dto.schedule.responseDto.ScheduleDetailResponseDto;
import com.sparta.schedule2.dto.schedule.responseDto.SchedulePageResponseDto;
import com.sparta.schedule2.dto.schedule.responseDto.ScheduleSaveResponseDto;
import com.sparta.schedule2.dto.schedule.responseDto.ScheduleUpdateResponseDto;
import com.sparta.schedule2.entity.Schedule;
import com.sparta.schedule2.entity.User;
import com.sparta.schedule2.entity.UserSchedule;
import com.sparta.schedule2.repository.ScheduleRepository;
import com.sparta.schedule2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    @Transactional
    public ScheduleSaveResponseDto saveSchedule(ScheduleSaveRequestDto requestDto) {
        User user = userRepository.findById(requestDto.getUserId()).orElseThrow(() -> new NoSuchElementException("사용자의 Id를 찾을 수 없습니다."));
        Schedule newSchedule = new Schedule(user, requestDto.getTitle(), requestDto.getDescription());
        Schedule savedSchedule = scheduleRepository.save(newSchedule);

        return new ScheduleSaveResponseDto(savedSchedule);
    }

    public ScheduleDetailResponseDto getSchedule(Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new NullPointerException("해당 ID를 가진 할일이 존재하지 않습니다."));
        ScheduleDetailResponseDto responseDto = new ScheduleDetailResponseDto(schedule);
        responseDto.setUsersSchedule(schedule.getAssignedUsers().stream().map(UserScheduleResponseDto::new).toList());


        return responseDto;
    }



    @Transactional
    public ScheduleUpdateResponseDto updateSchedule(Long scheduleId, ScheduleUpdateRequestDto requestDto) {
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new NullPointerException("해당 ID를 가진 할일이 존재하지 않습니다."));

        schedule.update(requestDto.getTitle(), requestDto.getDescription());

        return new ScheduleUpdateResponseDto(schedule.getId(), schedule.getUser(),
                schedule.getTitle(), schedule.getDescription(),
                schedule.getCreatedDate(), schedule.getModifiedDate());
    }

    public List<SchedulePageResponseDto> getSchedules(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.DESC, "modifiedDate"));
        Page<SchedulePageResponseDto> page = scheduleRepository.findAll(pageable)
                .map(SchedulePageResponseDto::from);
        return page.getContent();
    }

    @Transactional
    public void deleteSchedule(Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new NullPointerException("해당 ID를 가진 할일이 존재하지 않습니다."));
        scheduleRepository.delete(schedule);
    }
}
