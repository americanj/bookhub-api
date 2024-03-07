package com.bookhub.controller;

import com.bookhub.domain.mapper.BookMapper;
import com.bookhub.domain.response.BookResponse;
import com.bookhub.domain.vo.BookVo;
import com.bookhub.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookMapper bookMapper;


    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{bookId}/disassociate-author")
    public void dissociateAuthor(@PathVariable Long bookId) {
        bookService.disassociateAuthorFromBook(bookId);
    }

    @GetMapping("/{bookId}")
    @ResponseStatus(HttpStatus.OK)
    public BookResponse getBook(@PathVariable Long bookId) {
        BookVo bookVo = bookService.getBook(bookId);
        return bookMapper.voToResponse(bookVo);
    }

}
