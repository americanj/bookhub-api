package com.bookhub.domain.exception;

public class BookNotFoundException extends DataBaseException{
    public BookNotFoundException(String message) {
        super(message);
    }

    public BookNotFoundException(Long bookId) {
        this(String.format("Não existe cadastro de livro de código: %d", bookId));
    }
}
