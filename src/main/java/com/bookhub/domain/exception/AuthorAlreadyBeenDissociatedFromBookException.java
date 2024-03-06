package com.bookhub.domain.exception;


import lombok.Getter;

@Getter
public class AuthorAlreadyBeenDissociatedFromBookException extends BusinessException {

    private static final long serialVersionUID = 1L;

    public AuthorAlreadyBeenDissociatedFromBookException(String message) {
        super(message);
    }

    public AuthorAlreadyBeenDissociatedFromBookException(Long bookId) {
        this(String.format("O livro de código: %d não possui autor vinculado!", bookId));
    }
}
