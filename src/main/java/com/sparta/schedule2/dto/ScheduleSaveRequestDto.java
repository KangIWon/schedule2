package com.sparta.schedule2.dto;

import lombok.Getter;


@Getter
public class ScheduleSaveRequestDto {
    private Long userId;
    private String title;
    private String description;
}
