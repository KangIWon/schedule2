package com.sparta.schedule2.dto.schedule.responseDto;

import com.sparta.schedule2.entity.Schedule;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SchedulePageResponseDto {
//    private String user;
    private String title;
    private String description;
    private int commentCount;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public static SchedulePageResponseDto from(Schedule schedule) {
        SchedulePageResponseDto dto = new SchedulePageResponseDto();
//        dto.user = schedule.getUser().getUsername();
        dto.title = schedule.getTitle();
        dto.description = schedule.getDescription();
        dto.commentCount = schedule.getComments().size();
        dto.createdDate = schedule.getCreatedDate();
        dto.modifiedDate = schedule.getModifiedDate();
        return dto;
    }
}
