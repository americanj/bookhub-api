package com.bookhub.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "book")
public class BookModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String isbn;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = true)
    private AuthorModel author;

    @OneToOne
    @JoinColumn(name = "stock_id", nullable = true)
    private StockModel stock;

    public void removeAuthorFromBook() {
        this.setAuthor(null);
    }

    public Boolean authorIsNull() {
        Boolean isNull = false;
        if (Objects.isNull(getAuthor())) isNull = true;
        return isNull;
    }

    public void removeStockFromBook() {
        this.setStock(null);
    }

    public Boolean stockIsNull() {
        Boolean isNull = false;
        if (Objects.isNull(getStock())) isNull = true;
        return isNull;
    }
}
