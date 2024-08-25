package com.sparta.schedule2.controller;

import com.sparta.schedule2.dto.*;
import com.sparta.schedule2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserSaveResponseDto> saveUser(@RequestBody UserSaveRequestDto requestDto) {
        return ResponseEntity.ok(userService.saveUser(requestDto));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDetailResponseDto> getUser(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getUser(userId));
    }

    @GetMapping
    public ResponseEntity<List<UserSimpleResponseDto>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserUpdateResponseDto> updateUser(@PathVariable Long userId,
                                                            @RequestBody UserUpdateRequestDto requestDto) {
        return ResponseEntity.ok(userService.updateUser(userId, requestDto));
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }

    @PostMapping("/{userId}/schedules/{scheduleId}")
    public void addScheduleToUser(@PathVariable Long userId, @PathVariable Long scheduleId) {
        userService.addScheduleToUser(userId, scheduleId);
    }

    @DeleteMapping("/{userId}/schedules/{scheduleId}")
    public void removeScheduleFromUser(@PathVariable Long userId, @PathVariable Long scheduleId) {
        userService.removeScheduleFromUser(userId, scheduleId);
    }
}
