package com.bookhub.domain.vo;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class BookVo {

    private Long id;
    private String title;
    private String isbn;
    private BigDecimal price;
    private AuthorVo author;
    private StockVo stock;
}


