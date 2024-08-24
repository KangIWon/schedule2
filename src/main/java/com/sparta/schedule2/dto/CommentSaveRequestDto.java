package com.sparta.schedule2.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentSaveRequestDto {
    private String username;
    private String description;
    private Long scheduleId;
}
