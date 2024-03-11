package com.bookhub.domain.exception.handler;

import com.bookhub.domain.exception.AuthorAlreadyBeenDissociatedInTheBookException;
import com.bookhub.domain.exception.AuthorAlreadyBeenSociatedInTheBookException;
import com.bookhub.domain.exception.AuthorNotFoundException;
import com.bookhub.domain.exception.BookNotFoundException;
import com.bookhub.domain.exception.EntityInUseException;
import com.bookhub.domain.exception.StockAlreadyBeenDissociatedInTheBookException;
import com.bookhub.domain.exception.StockNotFoundException;
import com.bookhub.domain.response.ExceptionResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.sql.SQLException;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AuthorNotFoundException.class)
    public ResponseEntity<ExceptionResponse> authorNotFound(AuthorNotFoundException exception) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(exception.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
    }

    @ExceptionHandler(StockNotFoundException.class)
    public ResponseEntity<ExceptionResponse> stockNotFound(StockNotFoundException exception) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(exception.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
    }

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ExceptionResponse> authorNotFound(BookNotFoundException exception) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(exception.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
    }

    @ExceptionHandler({DataIntegrityViolationException.class, SQLException.class})
    public ResponseEntity<ExceptionResponse> entityInUse() {
        EntityInUseException entityInUseException = new EntityInUseException();
        ExceptionResponse exceptionResponse = new ExceptionResponse(entityInUseException.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }

    @ExceptionHandler(AuthorAlreadyBeenDissociatedInTheBookException.class)
    public ResponseEntity<ExceptionResponse> authorNotFound(AuthorAlreadyBeenDissociatedInTheBookException exception) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(exception.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }

    @ExceptionHandler(StockAlreadyBeenDissociatedInTheBookException.class)
    public ResponseEntity<ExceptionResponse> stockNotFound(StockAlreadyBeenDissociatedInTheBookException exception) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(exception.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }

    @ExceptionHandler(AuthorAlreadyBeenSociatedInTheBookException.class)
    public ResponseEntity<ExceptionResponse> authorNotFound(AuthorAlreadyBeenSociatedInTheBookException exception) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(exception.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }
}
