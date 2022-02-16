package com.sparta.homework.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
public class CommentRequestDto {

    private final String name;
    private final String content;
}
