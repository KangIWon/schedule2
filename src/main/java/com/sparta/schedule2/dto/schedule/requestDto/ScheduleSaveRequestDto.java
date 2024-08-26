package com.sparta.schedule2.dto.schedule.requestDto;

import lombok.Getter;


@Getter
public class ScheduleSaveRequestDto {
    private Long userId;
    private String title;
    private String description;
}
