package com.sparta.schedule2.dto;

import com.sparta.schedule2.entity.User;
import lombok.Getter;

@Getter
public class ScheduleUpdateRequestDto {
    private String user;
    private String title;
    private String description;
}
