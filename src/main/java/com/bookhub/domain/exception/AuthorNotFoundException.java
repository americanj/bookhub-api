package com.bookhub.domain.exception;

public class AuthorNotFoundException extends EntityNotFoundException {

    public AuthorNotFoundException(String message) {
        super(message);
    }

    public AuthorNotFoundException(Long authorId) {
        this(String.format("Não existe um cadastro de autor com código: %d", authorId));
    }
}
