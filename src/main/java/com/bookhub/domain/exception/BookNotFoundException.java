package com.bookhub.domain.exception;

public class BookNotFoundException extends EntityNotFoundException{
    public BookNotFoundException(String message) {
        super(message);
    }

    public BookNotFoundException(Long bookId) {
        this(String.format("Não existe cadastro de livro de código: %d", bookId));
    }
}
