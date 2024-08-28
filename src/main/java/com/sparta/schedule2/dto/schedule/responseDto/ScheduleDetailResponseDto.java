package com.sparta.schedule2.dto.schedule.responseDto;

import com.sparta.schedule2.dto.userschedule.UserScheduleResponseDto;
import com.sparta.schedule2.entity.Schedule;
import com.sparta.schedule2.entity.User;
import com.sparta.schedule2.entity.UserSchedule;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
public class ScheduleDetailResponseDto {
    private final Long id;
    private final Long userId;
    private final String title;
    private final String description;
    private final LocalDateTime createdDate;
    private final LocalDateTime modifiedDate;

    public ScheduleDetailResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.userId = schedule.getUser().getId();
        this.title = schedule.getTitle();
        this.description = schedule.getDescription();
        this.createdDate = schedule.getCreatedDate();
        this.modifiedDate = schedule.getModifiedDate();
    }

//    public static ScheduleDetailResponseDto fromEntity(Schedule schedule) {
//        List<String> assigneeNames = schedule.getAssignees().stream()
//                .map(userSchedule -> userSchedule.getUser().getUsername())
//                .collect(Collectors.toList());
//
//        return new ScheduleDetailResponseDto(
//                schedule.getId(),
//                schedule.getUser(),
//                schedule.getTitle(),
//                schedule.getDescription(),
//                schedule.getCreatedDate(),
//                schedule.getModifiedDate(),
//                assigneeNames
//        );
//    }
}