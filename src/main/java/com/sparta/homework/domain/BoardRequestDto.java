package com.sparta.homework.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
public class BoardRequestDto {

    private final String name;
    private final String title;
    private final String content;

}
