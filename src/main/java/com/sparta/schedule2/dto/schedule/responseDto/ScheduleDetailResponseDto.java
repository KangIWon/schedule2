package com.sparta.schedule2.dto.schedule.responseDto;

import com.sparta.schedule2.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class ScheduleDetailResponseDto {
    private final Long id;
    private final String user;
    private final String email;
    private final String title;
    private final String description;
    private final LocalDateTime createdDate;
    private final LocalDateTime modifiedDate;

    public ScheduleDetailResponseDto(Long id, User user, String title, String description, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.user = user.getUsername();
        this.email = user.getEmail();
        this.title = title;
        this.description = description;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
