package com.bookhub.domain.vo;

import lombok.Data;

@Data
public class BookVo {

    private Long id;
    private String title;
    private String isbn;
    private AuthorVo author;
}


