package com.bookhub.domain.response;

import lombok.Data;

@Data
public class StockResponse {

    private Long id;
    private Integer quantity;
    private Boolean active;
}