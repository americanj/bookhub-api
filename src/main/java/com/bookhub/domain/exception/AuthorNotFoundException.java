package com.bookhub.domain.exception;

import lombok.Getter;

@Getter
public class AuthorNotFoundException extends DataBaseException {

    public AuthorNotFoundException(String message) {
        super(message);
    }

    public AuthorNotFoundException(Long authorId) {
        this(String.format("Não existe um cadastro de autor com ID %d", authorId));
    }
}
