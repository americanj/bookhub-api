package com.bookhub.domain.exception;

import lombok.Getter;

@Getter
public class AuthorAlreadyBeenDissociatedInTheBookException extends EntityAlreadyBeenDissociatedInTheBookException {

    private static final long serialVersionUID = 1L;

    public AuthorAlreadyBeenDissociatedInTheBookException(String message) {
        super(message);
    }

    public AuthorAlreadyBeenDissociatedInTheBookException(Long bookId) {
        this(String.format("O livro de código: %d não possui autor vinculado!", bookId));
    }
}