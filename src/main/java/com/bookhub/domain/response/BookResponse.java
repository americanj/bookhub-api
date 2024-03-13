package com.bookhub.domain.response;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class BookResponse {

    private Long id;
    private String title;
    private String isbn;
    private BigDecimal price;
    private AuthorIdAndNameResponse author;
    private StockResponse stock;
}
