package com.sparta.schedule2.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentSaveRepository {
    private final Long id;
    private final String description;
    private final LocalDateTime createdDate;
    private final LocalDateTime modifiedDate;
    private final String username;

    public CommentSaveRepository(Long id, String description, LocalDateTime createdDate, LocalDateTime modifiedDate, String username) {
        this.id = id;
        this.description = description;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.username = username;
    }
}
