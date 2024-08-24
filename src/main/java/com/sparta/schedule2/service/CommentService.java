package com.sparta.schedule2.service;

import com.sparta.schedule2.dto.*;
import com.sparta.schedule2.entity.Comment;
import com.sparta.schedule2.entity.Schedule;
import com.sparta.schedule2.repository.CommentRepository;
import com.sparta.schedule2.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;

    @Transactional
    public CommentSaveResponseDto saveComment(CommentSaveRequestDto requestDto) {
        System.out.println(requestDto.getScheduleId());
        Schedule schedule = scheduleRepository.findById(requestDto.getScheduleId())
                .orElseThrow(() -> new NullPointerException("해당 ID를 가진 스케줄이 존재하지 않습니다."));

        Comment newComment = new Comment(requestDto.getUsername(), requestDto.getDescription(), schedule);
        Comment savedComment = commentRepository.save(newComment);

        return new CommentSaveResponseDto(savedComment.getId(), savedComment.getUsername(), savedComment.getDescription(),
                savedComment.getCreatedDate(), savedComment.getModifiedDate());
    }

    public CommentDetailResponseDto getComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new NullPointerException("해당 ID를 가진 댓글이 존재하지 않습니다."));

        return new CommentDetailResponseDto(comment.getId(), comment.getUsername(), comment.getDescription(),
                comment.getCreatedDate(), comment.getModifiedDate());
    }

    public List<CommentSimpleResponseDto> getComments() {
        List<Comment> commentList = commentRepository.findAll();

        List<CommentSimpleResponseDto> dtoList = new ArrayList<>();
        for (Comment comment : commentList) {
            CommentSimpleResponseDto dto = new CommentSimpleResponseDto(comment.getUsername(), comment.getDescription(),
                    comment.getCreatedDate(), comment.getModifiedDate());
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Transactional
    public CommentUpdateResponseDto updateComment(Long commentId, CommentUpdateRequestDto requestDto) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new NullPointerException("해당 ID를 가진 댓글이 존재하지 않습니다."));

        comment.update(requestDto.getDescription(), requestDto.getUsername());
        return new CommentUpdateResponseDto(comment.getId(), comment.getUsername(), comment.getDescription(),
                comment.getCreatedDate(), comment.getModifiedDate());
    }

    @Transactional
    public void deleteComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new NullPointerException("해당 ID를 가진 댓글이 존재하지 않습니다."));
        commentRepository.delete(comment);
    }
}
