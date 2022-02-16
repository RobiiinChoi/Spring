package com.sparta.homework.error;

import com.sparta.homework.error.exception.NullPointerException;
import com.sparta.homework.error.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler({NullPointerException.class})
    public ResponseEntity<ErrorResponse> nullPointer(Exception e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)   // 500
                .body(
                        ErrorResponse.builder()
                                .message("This page doesn't existed")
                                .exceptionType(e.getClass().getSimpleName())
                                .build()
                );
    }

}
