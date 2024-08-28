package com.sparta.schedule2.service;

import com.sparta.schedule2.dto.user.requestDto.UserSaveRequestDto;
import com.sparta.schedule2.dto.user.requestDto.UserUpdateRequestDto;
import com.sparta.schedule2.dto.user.responseDto.*;
import com.sparta.schedule2.entity.Schedule;
import com.sparta.schedule2.entity.User;
import com.sparta.schedule2.entity.UserSchedule;
import com.sparta.schedule2.repository.ScheduleRepository;
import com.sparta.schedule2.repository.UserRepository;
import com.sparta.schedule2.repository.UserScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ScheduleRepository scheduleRepository;
    private final UserScheduleRepository userScheduleRepository;

    @Transactional
    public UserSaveResponseDto saveUser(UserSaveRequestDto requestDto) {
        User newUser = new User(requestDto.getUsername(), requestDto.getEmail());
        User savedUser = userRepository.save(newUser);
        return new UserSaveResponseDto(savedUser.getId(), savedUser.getUsername(), savedUser.getEmail(),
                savedUser.getCreatedDate(), savedUser.getModifiedDate());
    }

    public UserDetailResponseDto getUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("해당 ID를 가진 유저가 존재하지 않습니다."));
        return new UserDetailResponseDto(user.getId(), user.getUsername(), user.getEmail(),
                user.getCreatedDate(), user.getModifiedDate());
    }

    public List<UserSimpleResponseDto> getUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> new UserSimpleResponseDto(user.getUsername(), user.getEmail(),
                        user.getCreatedDate(), user.getModifiedDate()))
                .toList();
    }

    @Transactional
    public UserUpdateResponseDto updateUser(Long userId, UserUpdateRequestDto requestDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("해당 ID를 가진 유저가 존재하지 않습니다."));
        user.update(requestDto.getUsername(), requestDto.getEmail());
        return new UserUpdateResponseDto(user.getId(), user.getUsername(), user.getEmail(),
                user.getCreatedDate(), user.getModifiedDate());
    }

    @Transactional
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("해당 ID를 가진 유저가 존재하지 않습니다."));
        // 삭제할 유저가 관련된 일정도 삭제하기 전에 먼저 중간 테이블에서 제거
        userScheduleRepository.deleteAll(user.getUserSchedules());
        userRepository.delete(user);
    }

    @Transactional
    public UserAddResponseDto addScheduleToUser(Long userId, Long scheduleId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("해당 ID를 가진 유저가 존재하지 않습니다."));
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new RuntimeException("해당 ID를 가진 일정이 존재하지 않습니다."));

        UserSchedule userSchedule = new UserSchedule(user, schedule);
        userScheduleRepository.save(userSchedule);
        return new UserAddResponseDto(user.getUsername(), schedule.getTitle());
    }

    @Transactional
    public void removeScheduleFromUser(Long userId, Long scheduleId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException("해당 ID를 가진 유저가 존재하지 않습니다."));
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(() -> new NoSuchElementException("해당 ID를 가진 일정이 존재하지 않습니다."));

        user.removeAssignedSchedule(schedule);
        schedule.removeAssignedUser(user);
    }
}
