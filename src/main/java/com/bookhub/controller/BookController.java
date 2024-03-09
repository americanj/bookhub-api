package com.bookhub.controller;

import com.bookhub.domain.mapper.BookMapper;
import com.bookhub.domain.request.BookRequest;
import com.bookhub.domain.response.BookResponse;
import com.bookhub.domain.vo.BookVo;
import com.bookhub.service.BookService;
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
    @DeleteMapping("/{bookId}/to-remove-author")
    public void dissociateAuthor(@PathVariable Long bookId) {
        bookService.disassociateAuthorFromBook(bookId);
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
    public BookResponse toCreateBook(@RequestBody BookRequest bookRequest) {
        BookVo bookVo = bookService.toCreateBook(bookRequest);
        return bookMapper.voToResponse(bookVo);
    }

    @PutMapping("/{bookId}")
    @ResponseStatus(HttpStatus.OK)
    public BookResponse toUpdateBook(@PathVariable Long bookId, @RequestBody BookRequest bookRequest) {
        BookVo bookVo = bookService.toUpdateBook(bookRequest, bookId);
        return bookMapper.voToResponse(bookVo);
    }

    @DeleteMapping("/{bookId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> toDeleteBook(@PathVariable Long bookId) {
        bookService.toDeleteBook(bookId);
        return ResponseEntity.noContent().build();
    }

}
