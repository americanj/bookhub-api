package com.bookhub.domain.exception;

public class StockInUseException extends BusinessException {
    public StockInUseException() {
        super("O autor fornecido, está em uso!");
    }
}
