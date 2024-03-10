package com.bookhub.domain.vo;

import lombok.Data;

@Data
public class StockVo {

    private Long id;
    private Integer quantity;
    private Boolean active;
}
