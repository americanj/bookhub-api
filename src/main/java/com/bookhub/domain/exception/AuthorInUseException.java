package com.bookhub.domain.exception;

import lombok.Getter;

@Getter
public class AuthorInUseException extends BusinessException {
    public AuthorInUseException() {
        super("O autor fornecido, está em uso!");
    }
}
