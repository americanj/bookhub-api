package com.bookhub.domain.vo;

import com.bookhub.domain.response.AuthorResumResponse;
import lombok.Data;

@Data
public class BookVo {

    private Long id;
    private String title;
    private String isbn;
    private AuthorResumResponse author;
}


