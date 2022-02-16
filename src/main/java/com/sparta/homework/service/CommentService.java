package com.sparta.homework.service;

import com.sparta.homework.domain.Comment;
import com.sparta.homework.domain.CommentRepository;
import com.sparta.homework.domain.CommentRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    @Transactional
    public Long updateComment(Long id, CommentRequestDto requestDto){
        Comment comment = commentRepository.findById(id).orElseThrow(
                ()->new NullPointerException("아이디가 존재하지 않습니다.") // try ~ catch
        );
        comment.update(requestDto);
        return comment.getId();
    }
}
