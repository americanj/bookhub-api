package com.bookhub.domain.exception;

public class AuthorInUseException extends BusinessException {
    public AuthorInUseException() {
        super("O autor fornecido, está em uso!");
    }
}
