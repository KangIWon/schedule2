package com.sparta.schedule2.dto;

import lombok.Getter;

@Getter
public class CommentUpdateRequestDto {
    private Long scheduleId;
    private String username;
    private String description;
}
