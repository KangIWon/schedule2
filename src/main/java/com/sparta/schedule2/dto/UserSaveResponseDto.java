package com.sparta.schedule2.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserSaveResponseDto {
    private final Long id;
    private final String username;
    private final String email;
    private final LocalDateTime createdDate;
    private final LocalDateTime modifiedDate;

    public UserSaveResponseDto(Long id, String username, String email, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
