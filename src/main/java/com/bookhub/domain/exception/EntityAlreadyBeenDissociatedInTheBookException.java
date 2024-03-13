package com.bookhub.domain.exception;

public class EntityAlreadyBeenDissociatedInTheBookException extends BusinessException {

    private static final long serialVersionUID = 1L;

    public EntityAlreadyBeenDissociatedInTheBookException(String message) {
        super(message);
    }

    public EntityAlreadyBeenDissociatedInTheBookException(String msg, Throwable causa) {
        super(msg, causa);
    }
}
