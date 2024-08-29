package com.sparta.schedule2.dto.userschedule;


import com.sparta.schedule2.entity.User;
import lombok.Getter;

@Getter

public class UserScheduleResponseDto {
    private final Long id;
    private final String username;
    private final String email;

    public UserScheduleResponseDto(User user)
    {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
    }

}
