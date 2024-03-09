package com.bookhub.domain.request;

import lombok.Data;

@Data
public class BookRequest {

    private String title;
    private String isbn;
    private AuthorIdRequest author;
}
