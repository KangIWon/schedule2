package com.sparta.schedule2.controller;

import com.sparta.schedule2.dto.*;
import com.sparta.schedule2.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comments")
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<CommentSaveResponseDto> saveComment(@RequestBody CommentSaveRequestDto requestDto) {
        return ResponseEntity.ok(commentService.saveComment(requestDto));
    }

    @GetMapping("{commentId}")
    public ResponseEntity<CommentDetailResponseDto> getComment(@PathVariable Long commentId){
        return ResponseEntity.ok(commentService.getComment(commentId));
    }

    @GetMapping
    public ResponseEntity<List<CommentSimpleResponseDto>> getComments() {
        return ResponseEntity.ok(commentService.getComments());
    }

    @PutMapping("{commentId}")
    public ResponseEntity<CommentUpdateResponseDto> updateComment(@PathVariable Long commentId,
                                                                  @RequestBody CommentUpdateRequestDto requestDto){
        return ResponseEntity.ok(commentService.updateComment(commentId, requestDto));
    }

    @DeleteMapping("{commentId}")
    public void deleteComment(@PathVariable Long commentId){
        commentService.deleteComment(commentId);
    }
}
