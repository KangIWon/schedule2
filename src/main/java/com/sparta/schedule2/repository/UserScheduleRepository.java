package com.sparta.schedule2.repository;

import com.sparta.schedule2.entity.Schedule;
import com.sparta.schedule2.entity.User;
import com.sparta.schedule2.entity.UserSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserScheduleRepository extends JpaRepository<UserSchedule, Long> {
    Optional<UserSchedule> findByUserAndSchedule(User user, Schedule schedule);
}
