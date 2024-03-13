package com.bookhub.domain.exception;


import lombok.Getter;

@Getter
public class AuthorAlreadyBeenSociatedInTheBookException extends EntityAlreadyBeenSociatedInTheBookException {

    private static final long serialVersionUID = 1L;

    public AuthorAlreadyBeenSociatedInTheBookException(String message) {
        super(message);
    }

    public AuthorAlreadyBeenSociatedInTheBookException(Long bookId) {
        this(String.format("O livro de código: %d já está vinculado a este autor!", bookId));
    }
}
