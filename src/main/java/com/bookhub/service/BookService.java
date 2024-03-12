package com.bookhub.service;

import com.bookhub.domain.exception.AuthorAlreadyBeenDissociatedInTheBookException;
import com.bookhub.domain.exception.AuthorAlreadyBeenSociatedInTheBookException;
import com.bookhub.domain.exception.EntityInUseException;
import com.bookhub.domain.exception.StockAlreadyBeenDissociatedInTheBookException;
import com.bookhub.domain.exception.StockAlreadyBeenSociatedInTheBookException;
import com.bookhub.domain.mapper.AuthorMapper;
import com.bookhub.domain.mapper.BookMapper;
import com.bookhub.domain.mapper.StockMapper;
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

    private static String MSG_STOCK_ALREADY_IN_USE = "O stock de código: %d já está em uso por outro livro!";

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private AuthorMapper authorMapper;

    @Autowired
    private StockMapper stockMapper;


    @Transactional
    public void dissociateAuthorInTheBook(@PathVariable Long bookId) {
        BookModel bookModel = bookRepository.findByIdOrThrowException(bookId);
        if (Boolean.TRUE.equals(bookModel.authorIsNull()))
            throw new AuthorAlreadyBeenDissociatedInTheBookException(bookId);
        bookModel.removeAuthorFromBook();
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
    public BookVo createBook(BookRequest bookRequest) {
        AuthorModel authorModel = null;
        StockModel stockModel = null;
        if (Objects.nonNull(bookRequest.getAuthorId())) authorModel = authorRepository.findByIdOrThrowException(bookRequest.getAuthorId());
        if (Objects.nonNull(bookRequest.getStockId())) stockModel = stockRepository.findByIdOrThrowException(bookRequest.getStockId());
        if (Boolean.TRUE.equals(bookRepository.existsByStockId(stockModel))) throw new EntityInUseException(String.format(MSG_STOCK_ALREADY_IN_USE, stockModel.getId()));
        BookModel bookModel = bookMapper.requestToModel(bookRequest);
        bookModel.setAuthor(authorModel);
        bookModel.setStock(stockModel);
        bookModel = bookRepository.save(bookModel);
        return bookMapper.modelToVo(bookModel);
    }

    /*@Transactional
    public BookVo updateBook(BookRequest bookRequest, Long bookId) {
        bookRepository.findByIdOrThrowException(bookId);
        AuthorModel authorModel = authorRepository.findByIdOrThrowException(bookRequest.getAuthor().getId());
        StockModel stockModel = stockRepository.findByIdOrThrowException(bookRequest.getStock().getId());
        BookModel bookModel = bookMapper.requestToModel(bookRequest, bookId);
        bookModel.setAuthor(authorModel);
        bookModel.setStock(stockModel);
        try {
            bookModel = bookRepository.save(bookModel);
            bookRepository.flush();
        } catch (DataIntegrityViolationException e) {
            throw new EntityInUseException(String.format(MSG_STOCK_ALREADY_IN_USE, stockModel.getId()));
        }
        return bookMapper.modelToVo(bookModel);
    }*/

    @Transactional
    public void deleteBook(Long bookId) {
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

    @Transactional
    public void dissociateStockInTheBook(@PathVariable Long bookId) {
        BookModel bookModel = bookRepository.findByIdOrThrowException(bookId);
        if (Boolean.TRUE.equals(bookModel.stockIsNull()))
            throw new StockAlreadyBeenDissociatedInTheBookException(bookId);
        bookModel.removeStockFromBook();
        bookRepository.save(bookModel);
    }

    @Transactional
    public void associateStockInTheBook(Long bookId, Long stockId) {
        BookModel bookModel = bookRepository.findByIdOrThrowException(bookId);
        StockModel stockModel = stockRepository.findByIdOrThrowException(stockId);
        if (Objects.nonNull(bookModel.getStock())) {
            if (bookModel.getStock().getId() == stockId) {
                throw new StockAlreadyBeenSociatedInTheBookException(bookId);
            } else {
                bookModel.setStock(stockModel);
                bookRepository.save(bookModel);
            }
        } else {
            bookModel.setStock(stockModel);
            bookRepository.save(bookModel);
        }
    }

}
