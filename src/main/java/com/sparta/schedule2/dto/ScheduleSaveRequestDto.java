package com.sparta.schedule2.dto;

import com.sparta.schedule2.entity.User;
import lombok.Getter;


@Getter
public class ScheduleSaveRequestDto {
    private Long userId;
    private String title;
    private String description;
}
