package com.sparta.schedule2.dto.comment.requestDto;

import lombok.Getter;

@Getter
public class CommentSaveRequestDto {
    private Long scheduleId;
    private String username;
    private String description;
}
