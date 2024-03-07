package com.bookhub.domain.response;

import com.bookhub.domain.model.AuthorModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {

    private Long id;
    private String title;
    private String isbn;
    private AuthorResumResponse author;
}
