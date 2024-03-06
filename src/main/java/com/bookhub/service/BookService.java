package com.bookhub.service;

import com.bookhub.domain.exception.AuthorAlreadyBeenDissociatedFromBookException;
import com.bookhub.domain.mapper.BookMapper;
import com.bookhub.domain.model.BookModel;
import com.bookhub.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;


    @Transactional
    public void disassociateAuthorFromBook(@PathVariable Long bookId) {
        BookModel bookModel = bookRepository.findByIdOrThrowException(bookId);
        if (Boolean.TRUE.equals(bookModel.authorIsNull())) throw new AuthorAlreadyBeenDissociatedFromBookException(bookId);
        bookModel.toRemoveAuthorFromBook();
        bookRepository.save(bookModel);
    }
}
