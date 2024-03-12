package com.bookhub.repository;

import com.bookhub.domain.exception.BookNotFoundException;
import com.bookhub.domain.model.BookModel;
import com.bookhub.domain.model.StockModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookModel, Long> {

    default BookModel findByIdOrThrowException(Long bookId) {
        return this.findById(bookId).orElseThrow(() -> new BookNotFoundException(bookId));
    }

    @Query("SELECT COUNT(b) > 0 FROM book b WHERE b.stock = :stock")
    boolean existsByStockId(@Param("stock") StockModel stock);
}
