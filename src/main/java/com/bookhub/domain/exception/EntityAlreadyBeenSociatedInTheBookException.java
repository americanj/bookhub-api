package com.bookhub.domain.exception;

public class EntityAlreadyBeenSociatedInTheBookException extends BusinessException {

    private static final long serialVersionUID = 1L;

    public EntityAlreadyBeenSociatedInTheBookException(String message) {
        super(message);
    }

    public EntityAlreadyBeenSociatedInTheBookException(String msg, Throwable causa) {
        super(msg, causa);
    }
}
