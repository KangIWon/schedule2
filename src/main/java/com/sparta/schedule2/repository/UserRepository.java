package com.sparta.schedule2.repository;

import com.sparta.schedule2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
