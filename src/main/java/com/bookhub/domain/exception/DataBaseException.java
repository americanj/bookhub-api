package com.bookhub.domain.exception;

import lombok.Getter;

@Getter
public class DataBaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DataBaseException(String message) {
        super(message);
    }
}