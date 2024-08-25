package com.sparta.schedule2.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserUpdateRequestDto {
    private String username;
    private String email;
    private LocalDateTime modifiedDate;
}
