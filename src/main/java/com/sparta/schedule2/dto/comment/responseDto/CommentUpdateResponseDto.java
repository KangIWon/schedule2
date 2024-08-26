package com.sparta.schedule2.dto.comment.responseDto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentUpdateResponseDto {
    private final Long id;
    private final String username;
    private final String description;
    private final LocalDateTime createdDate;
    private final LocalDateTime modifiedDate;

    public CommentUpdateResponseDto(Long id, String username, String description, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
