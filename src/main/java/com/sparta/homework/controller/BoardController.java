package com.sparta.homework.controller;

import com.sparta.homework.domain.Board;
import com.sparta.homework.domain.BoardRepository;
import com.sparta.homework.domain.BoardRequestDto;
import com.sparta.homework.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardRepository repository;
    private final BoardService service;

    @PostMapping("/api/boards")
    public Board createBoard(@RequestBody BoardRequestDto requestDto){
        Board board = new Board(requestDto);
        return repository.save(board);
    }

    @GetMapping("/api/boards")
    public List<Board> readBoard(){
        return repository.findAllByOrderByCreatedAtDesc();
    }

    @GetMapping("/api/boards/{id}")
    public ResponseEntity<Board> readBoardDetail(@PathVariable Long id){
        Board board = repository.findById(id).orElseThrow(
                ()-> new NullPointerException("해당 아이디에 대한 게시물이 없습니다.")
        );
        return ResponseEntity.ok(board);
    }

    @DeleteMapping("/api/boards/{id}")
    public Long deleteBoard(@PathVariable Long id){
        repository.deleteById(id);
        return id;
    }

    @PutMapping("/api/boards/{id}")
    public Long updateBoard(Long id, BoardRequestDto requestDto){
        service.update(id, requestDto);
        return id;
    }
}
