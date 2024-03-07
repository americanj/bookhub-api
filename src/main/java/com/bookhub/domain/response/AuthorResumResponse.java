package com.bookhub.domain.response;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class AuthorResumResponse {

    private Long id;
    private String name;
}
