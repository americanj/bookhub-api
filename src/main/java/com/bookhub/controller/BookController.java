package com.bookhub.controller;

import com.bookhub.domain.mapper.BookMapper;
import com.bookhub.domain.request.BookRequest;
import com.bookhub.domain.response.BookResponse;
import com.bookhub.domain.vo.BookVo;
import com.bookhub.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookMapper bookMapper;


    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{bookId}/remove-author")
    public void dissociateAuthor(@PathVariable Long bookId) {
        bookService.dissociateAuthorInTheBook(bookId);
    }

    @GetMapping("/{bookId}")
    @ResponseStatus(HttpStatus.OK)
    public BookResponse getBook(@PathVariable Long bookId) {
        BookVo bookVo = bookService.getBook(bookId);
        return bookMapper.voToResponse(bookVo);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BookResponse> getBooks() {
        List<BookVo> bookVos = bookService.getBooks();
        return bookMapper.vosToResponses(bookVos);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public BookResponse createBook(@RequestBody @Valid BookRequest bookRequest) {
        BookVo bookVo = bookService.createBook(bookRequest);
        return bookMapper.voToResponse(bookVo);
    }

    @PutMapping("/{bookId}")
    @ResponseStatus(HttpStatus.OK)
    public BookResponse updateBook(@PathVariable Long bookId, @RequestBody BookRequest bookRequest) {
        BookVo bookVo = bookService.updateBook(bookRequest, bookId);
        return bookMapper.voToResponse(bookVo);
    }

    @DeleteMapping("/{bookId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteBook(@PathVariable Long bookId) {
        bookService.deleteBook(bookId);
        return ResponseEntity.noContent().build();
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{bookId}/add-author/{authorId}")
    public ResponseEntity<Void> sociateAuthor(@PathVariable Long bookId, @PathVariable Long authorId) {
        bookService.associateAuthorInTheBook(bookId, authorId);
        return ResponseEntity.ok().build();
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{bookId}/remove-stock")
    public void dissociateStock(@PathVariable Long bookId) {
        bookService.dissociateStockInTheBook(bookId);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{bookId}/add-stock/{stockId}")
    public ResponseEntity<Void> sociateStock(@PathVariable Long bookId, @PathVariable Long stockId) {
        bookService.associateStockInTheBook(bookId, stockId);
        return ResponseEntity.ok().build();
    }
}
