package com.bookhub.domain.exception.handler;

import com.bookhub.domain.exception.AuthorNotFoundException;
import com.bookhub.domain.exception.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AuthorNotFoundException.class)
    public ResponseEntity<ExceptionResponse> authorNotFound(AuthorNotFoundException exception) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(exception.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
    }
}
