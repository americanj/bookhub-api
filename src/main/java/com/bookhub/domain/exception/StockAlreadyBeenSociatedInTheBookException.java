package com.bookhub.domain.exception;


import lombok.Getter;

@Getter
public class StockAlreadyBeenSociatedInTheBookException extends BusinessException {

    private static final long serialVersionUID = 1L;

    public StockAlreadyBeenSociatedInTheBookException(String message) {
        super(message);
    }

    public StockAlreadyBeenSociatedInTheBookException(Long bookId) {
        this(String.format("O livro de código: %d já está vinculado a este stock!!", bookId));
    }
}
