package com.sparta.homework.service;

import com.sparta.homework.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository repository;

    @Transactional
    public Long update(Long id, BoardRequestDto requestDto){
        Board board = repository.findById(id).orElseThrow(
                ()->new NullPointerException("아이디가 존재하지 않습니다.")
        );
        board.update(requestDto);
        return board.getId();
    }

}
