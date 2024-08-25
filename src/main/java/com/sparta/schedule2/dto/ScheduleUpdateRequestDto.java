package com.sparta.schedule2.dto;

import lombok.Getter;

@Getter
public class ScheduleUpdateRequestDto {
    private String user;
    private String title;
    private String description;
}
