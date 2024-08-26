package com.sparta.schedule2.dto.user.responseDto;

import lombok.Getter;

@Getter
public class UserAddResponseDto {
    private final String username;
    private final String title;

    public UserAddResponseDto(String username, String title) {
        this.username = username;
        this.title = title;
    }
}
