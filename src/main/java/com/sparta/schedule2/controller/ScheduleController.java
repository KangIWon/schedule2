package com.sparta.schedule2.controller;

import com.sparta.schedule2.dto.schedule.requestDto.ScheduleSaveRequestDto;
import com.sparta.schedule2.dto.schedule.requestDto.ScheduleUpdateRequestDto;
import com.sparta.schedule2.dto.schedule.responseDto.ScheduleDetailResponseDto;
import com.sparta.schedule2.dto.schedule.responseDto.SchedulePageResponseDto;
import com.sparta.schedule2.dto.schedule.responseDto.ScheduleSaveResponseDto;
import com.sparta.schedule2.dto.schedule.responseDto.ScheduleUpdateResponseDto;
import com.sparta.schedule2.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/schedules")
public class ScheduleController {
    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<ScheduleSaveResponseDto> saveSchedule(@RequestBody ScheduleSaveRequestDto requestDto) {
        return ResponseEntity.ok(scheduleService.saveSchedule(requestDto));
    }

    @GetMapping("/{scheduleId}")
    public ResponseEntity<ScheduleDetailResponseDto> getSchedule(@PathVariable Long scheduleId) {
        return ResponseEntity.ok(scheduleService.getSchedule(scheduleId));
    }

    @PutMapping("/{scheduleId}")
    public ResponseEntity<ScheduleUpdateResponseDto> updateSchedule(@PathVariable Long scheduleId, @RequestBody ScheduleUpdateRequestDto requestDto) {
        return ResponseEntity.ok(scheduleService.updateSchedule(scheduleId, requestDto));
    }

    @GetMapping
    public ResponseEntity<List<SchedulePageResponseDto>> getSchedules(@RequestParam(defaultValue = "0") int pageNo,
                                                                      @RequestParam(defaultValue = "10") int pageSize) {
        return ResponseEntity.ok(scheduleService.getSchedules(pageNo, pageSize));
    }

    @DeleteMapping("/{scheduleId}")
    public void deleteSchedule(@PathVariable Long scheduleId) {
        scheduleService.deleteSchedule(scheduleId);
    }
}
