package com.sparta.schedule2.dto;

import com.sparta.schedule2.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SchedulePageResponseDto {
    private String username;
    private String title;
    private String description;
    private int commentCount;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

//    public SchedulePageResponseDto (String username, String title, String description, Schedule schedule, LocalDateTime createdDate, LocalDateTime modifiedDate) {
//        this.username = username;
//        this.title = title;
//        this.description = description;
//        this.commentCount = schedule.getComments().size();
//        this.createdDate = createdDate;
//        this.modifiedDate = modifiedDate;
//    }

    public static SchedulePageResponseDto from(Schedule schedule) {
        SchedulePageResponseDto dto = new SchedulePageResponseDto();
        dto.username = schedule.getUsername();
        dto.title = schedule.getTitle();
        dto.description = schedule.getDescription();
        dto.commentCount = schedule.getComments().size();
        dto.createdDate = schedule.getCreatedDate();
        dto.modifiedDate = schedule.getModifiedDate();
        return dto;
    }
}
