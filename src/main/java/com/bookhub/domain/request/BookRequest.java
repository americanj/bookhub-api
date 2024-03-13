package com.bookhub.domain.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class BookRequest {

    @NotNull
    @NotBlank
    private String title;

    @NotNull
    @NotBlank
    private String isbn;

    @NotNull
    private BigDecimal price;

    private Long authorId;
    private Long stockId;
}
