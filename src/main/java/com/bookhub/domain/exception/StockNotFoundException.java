package com.bookhub.domain.exception;

public class StockNotFoundException extends EntityNotFoundException{
    public StockNotFoundException(String message) {
        super(message);
    }

    public StockNotFoundException(Long stockId) {
        this(String.format("Não existe cadastro de stock com código: %d", stockId));
    }
}
