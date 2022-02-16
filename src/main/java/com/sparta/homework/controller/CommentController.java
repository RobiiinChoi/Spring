package com.sparta.homework.controller;

import com.sparta.homework.domain.*;
import com.sparta.homework.service.BoardService;
import com.sparta.homework.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class CommentController {

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;
    private final CommentService service;

    @GetMapping("/{id}/comments")
    public List<Comment> getPostComment(@PathVariable Long id){
        Board board = boardRepository.findById(id).get();
        return commentRepository.findCommentsByBoardOrderByCreatedAtDesc(board);
    }

    @DeleteMapping("/comments/{commentId}")
    public Long deleteBoard(@PathVariable Long commentId){
        commentRepository.deleteById(commentId);
        return commentId;
    }

    @PutMapping("/comments/{commentId}")
    public Long updateComment(@PathVariable Long commentId,@RequestBody CommentRequestDto requestDto){
        service.updateComment(commentId, requestDto);
        return commentId;
    }

    @PostMapping("/{id}/comments")
    public Long createComment(@PathVariable Long id, @RequestBody CommentRequestDto requestDto){
        Comment comment = new Comment(requestDto);
        Board board = boardRepository.findById(id).orElseThrow(()->new IllegalArgumentException("댓글을 작성할 게시글이 없습니다."));
        comment.addTo(board);
        Comment save = commentRepository.save(comment);
        return save.getId();
    }

}
