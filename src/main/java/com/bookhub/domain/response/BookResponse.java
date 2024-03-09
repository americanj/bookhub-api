package com.bookhub.domain.response;

import lombok.Data;

@Data
public class BookResponse {

    private Long id;
    private String title;
    private String isbn;
    private AuthorIdAndNameResponse author;
}
