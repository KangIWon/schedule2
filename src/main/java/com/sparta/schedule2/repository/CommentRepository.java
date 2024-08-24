package com.sparta.schedule2.repository;

import com.sparta.schedule2.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
