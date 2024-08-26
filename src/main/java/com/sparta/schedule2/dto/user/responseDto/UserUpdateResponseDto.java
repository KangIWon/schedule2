package com.sparta.schedule2.dto.user.responseDto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserUpdateResponseDto {
    private final Long id;
    private final String username;
    private final String email;
    private final LocalDateTime createdDate;
    private final LocalDateTime modifiedDate;

    public UserUpdateResponseDto(Long id, String username, String email, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
