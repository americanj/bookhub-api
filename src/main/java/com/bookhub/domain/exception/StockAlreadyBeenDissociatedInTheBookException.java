package com.bookhub.domain.exception;

public class StockAlreadyBeenDissociatedInTheBookException extends BusinessException {

    private static final long serialVersionUID = 1L;

    public StockAlreadyBeenDissociatedInTheBookException(String message) {
        super(message);
    }

    public StockAlreadyBeenDissociatedInTheBookException(Long bookId) {
        this(String.format("O livro de código: %d não possui stock vinculado!", bookId));
    }
}
