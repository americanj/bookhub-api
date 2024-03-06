package com.bookhub.domain.vo;

import com.bookhub.domain.model.AuthorModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookVo {

    private Long id;
    private String title;
    private String isbn;
    private Long authorId;
}


