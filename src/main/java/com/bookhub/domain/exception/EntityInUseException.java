package com.bookhub.domain.exception;

public class EntityInUseException extends BusinessException {

    public EntityInUseException(String msg) {
        super(msg);
    }
}