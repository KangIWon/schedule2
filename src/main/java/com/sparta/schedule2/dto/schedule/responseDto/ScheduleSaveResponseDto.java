package com.sparta.schedule2.dto.schedule.responseDto;

import com.sparta.schedule2.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleSaveResponseDto {
    private final Long id;
    private final String user;
    private final String title;
    private final String description;
    private final LocalDateTime createdDate;
    private final LocalDateTime modifiedDate;

    public ScheduleSaveResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.user = schedule.getUser().getUsername();
        this.title = schedule.getTitle();
        this.description = schedule.getDescription();
        this.createdDate = schedule.getCreatedDate();
        this.modifiedDate = schedule.getModifiedDate();
    }
}
