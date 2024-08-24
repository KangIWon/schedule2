package com.sparta.schedule2.service;

import com.sparta.schedule2.dto.CommentSaveReauestDto;
import com.sparta.schedule2.dto.CommentSaveRepository;
import com.sparta.schedule2.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

//    public CommentSaveRepository saveComment(CommentSaveReauestDto reauestDto) {
//    }
}
