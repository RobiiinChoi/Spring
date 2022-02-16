package com.sparta.homework.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    // 코멘트 - 게시글
    List<Comment> findCommentsByBoardOrderByCreatedAtDesc(Board board);
}

