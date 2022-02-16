package com.sparta.homework.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Comment extends Timestamp{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @Builder
    public Comment(CommentRequestDto requestDto){
        this.name = requestDto.getName();
        this.content = requestDto.getContent();
    }

    public void update(CommentRequestDto requestDto){
        this.name = requestDto.getName();
        this.content = requestDto.getContent();
    }

    public void addTo(Board board){
        this.board = board;
    }

}
