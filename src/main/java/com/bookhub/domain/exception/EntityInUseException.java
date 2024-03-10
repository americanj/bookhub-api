package com.bookhub.domain.exception;

public class EntityInUseException extends BusinessException {

    public EntityInUseException() {
        super("O recurso fornecido, está em uso!");
    }
}