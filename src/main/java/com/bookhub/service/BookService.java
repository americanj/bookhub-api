package com.bookhub.service;

import com.bookhub.domain.exception.AuthorAlreadyBeenDissociatedInTheBookException;
import com.bookhub.domain.exception.AuthorAlreadyBeenSociatedInTheBookException;
import com.bookhub.domain.mapper.BookMapper;
import com.bookhub.domain.model.AuthorModel;
import com.bookhub.domain.model.BookModel;
import com.bookhub.domain.model.StockModel;
import com.bookhub.domain.request.BookRequest;
import com.bookhub.domain.vo.BookVo;
import com.bookhub.repository.AuthorRepository;
import com.bookhub.repository.BookRepository;
import com.bookhub.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import java.util.Objects;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private StockRepository stockRepository;


    @Transactional
    public void dissociateAuthorInTheBook(@PathVariable Long bookId) {
        BookModel bookModel = bookRepository.findByIdOrThrowException(bookId);
        if (Boolean.TRUE.equals(bookModel.authorIsNull())) throw new AuthorAlreadyBeenDissociatedInTheBookException(bookId);
        bookModel.toRemoveAuthorFromBook();
        bookRepository.save(bookModel);
    }

    public BookVo getBook(Long bookId) {
        BookModel bookModel = bookRepository.findByIdOrThrowException(bookId);
        return bookMapper.modelToVo(bookModel);
    }

    public List<BookVo> getBooks() {
        List<BookModel> bookModels = bookRepository.findAll();
        return bookMapper.modelsToVos(bookModels);
    }

    @Transactional
    public BookVo toCreateBook(BookRequest bookRequest) {
        AuthorModel authorModel = authorRepository.findByIdOrThrowException(bookRequest.getAuthor().getId());
        StockModel stockModel = stockRepository.findByIdOrThrowException(bookRequest.getStock().getId());
        BookModel bookModel = bookMapper.requestToModel(bookRequest);
        bookModel.setAuthor(authorModel);
        bookModel.setStock(stockModel);
        bookModel = bookRepository.save(bookModel);
        return bookMapper.modelToVo(bookModel);
    }

    @Transactional
    public BookVo toUpdateBook(BookRequest bookRequest, Long bookId) {
        bookRepository.findByIdOrThrowException(bookId);
        AuthorModel authorModel = authorRepository.findByIdOrThrowException(bookRequest.getAuthor().getId());
        BookModel bookModel = bookMapper.requestToModel(bookRequest, bookId);
        bookModel.setAuthor(authorModel);
        bookModel = bookRepository.save(bookModel);
        return bookMapper.modelToVo(bookModel);
    }

    @Transactional
    public void toDeleteBook(Long bookId) {
        BookModel bookModel = bookRepository.findByIdOrThrowException(bookId);
        bookRepository.delete(bookModel);
    }

    @Transactional
    public void associateAuthorInTheBook(Long bookId, Long authorId) {
        BookModel bookModel = bookRepository.findByIdOrThrowException(bookId);
        AuthorModel authorModel = authorRepository.findByIdOrThrowException(authorId);
        if (Objects.nonNull(bookModel.getAuthor())) {
            if (bookModel.getAuthor().getId() == authorId) {
                throw new AuthorAlreadyBeenSociatedInTheBookException(bookId);
            } else {
                bookModel.setAuthor(authorModel);
                bookRepository.save(bookModel);
            }
        } else {
            bookModel.setAuthor(authorModel);
            bookRepository.save(bookModel);
        }
    }

}
