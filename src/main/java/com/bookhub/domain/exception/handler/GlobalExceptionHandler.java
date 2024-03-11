package com.bookhub.domain.exception.handler;

import com.bookhub.domain.exception.AuthorAlreadyBeenDissociatedInTheBookException;
import com.bookhub.domain.exception.AuthorAlreadyBeenSociatedInTheBookException;
import com.bookhub.domain.exception.AuthorNotFoundException;
import com.bookhub.domain.exception.BookNotFoundException;
import com.bookhub.domain.exception.EntityInUseException;
import com.bookhub.domain.exception.StockAlreadyBeenDissociatedInTheBookException;
import com.bookhub.domain.exception.StockAlreadyBeenSociatedInTheBookException;
import com.bookhub.domain.exception.StockNotFoundException;
import com.bookhub.domain.response.ExceptionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;



@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

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

    /*@ExceptionHandler({DataIntegrityViolationException.class, SQLException.class})
    public ResponseEntity<ExceptionResponse> entityInUse() {
        EntityInUseException entityInUseException = new EntityInUseException();
        ExceptionResponse exceptionResponse = new ExceptionResponse(entityInUseException.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }*/

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

    @ExceptionHandler(StockAlreadyBeenSociatedInTheBookException.class)
    public ResponseEntity<ExceptionResponse> authorNotFound(StockAlreadyBeenSociatedInTheBookException exception) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(exception.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }


    @ExceptionHandler(EntityInUseException.class)
    public ResponseEntity<?> handleEntidadeEmUso(EntityInUseException ex, WebRequest request){

        HttpStatus status = HttpStatus.CONFLICT;
        ProblemType problemType = ProblemType.ENTIDADE_EM_USO;
        String detail = ex.getMessage();

        Problem problem = createProblemBuilder(status, problemType, detail)
                .userMessage(detail)
                .build();

        return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
      }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return handleValidationInternal(ex, ex.getBindingResult(), headers, (HttpStatus) status, request);
    }

    private Problem.ProblemBuilder createProblemBuilder(HttpStatus status, ProblemType problemType, String detail){
        return Problem.builder().status(status.value()).type(problemType.getUri()).title(problemType.getTitle()).detail(detail).timestamp(OffsetDateTime.now());
    }

    private ResponseEntity<Object> handleValidationInternal(Exception ex, BindingResult bindingResult, HttpHeaders headers, HttpStatus status, WebRequest request){

        ProblemType problemType = ProblemType.DADOS_INVALIDOS;
        String detail = "Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.";

        List<Problem.Object> problemObjects = bindingResult.getAllErrors().stream()
                .map(objectError -> {
                    String message = messageSource.getMessage(objectError, LocaleContextHolder.getLocale());
                    String name = objectError.getObjectName();
                    if(objectError instanceof FieldError){
                        name = ((FieldError) objectError).getField();
                    }

                    return Problem.Object.builder()
                            .name(name)
                            .userMessage(message)
                            .build();
                })
                .collect(Collectors.toList());

        Problem problem = createProblemBuilder(status, problemType, detail)
                .userMessage(detail)
                .objects(problemObjects)
                .build();

        return handleExceptionInternal(ex, problem, headers, status, request);
    }
}
