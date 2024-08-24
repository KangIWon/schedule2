package com.sparta.schedule2.controller;

import com.sparta.schedule2.dto.CommentSaveReauestDto;
import com.sparta.schedule2.dto.CommentSaveRepository;
import com.sparta.schedule2.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comments")
public class CommentController {
    private final CommentService commentService;

//    @PostMapping
//    public ResponseEntity<CommentSaveRepository> saveComment(@RequestBody CommentSaveReauestDto reauestDto) {
//        return ResponseEntity.ok(commentService.saveComment(reauestDto));
//    }
}
