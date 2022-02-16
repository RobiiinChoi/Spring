package com.sparta.homework.error.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorResponse {

    private String message;
    private String exceptionType;

}
