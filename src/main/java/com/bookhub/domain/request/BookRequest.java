package com.bookhub.domain.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class BookRequest {

    private String title;
    private String isbn;
    private Long authorId;
}
