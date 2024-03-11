package com.bookhub.domain.request;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class BookRequest {

    private String title;
    private String isbn;
    private BigDecimal price;
    private StockIdRequest stock;
    private AuthorIdRequest author;
}
