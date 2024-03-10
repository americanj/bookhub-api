package com.bookhub.repository;

import com.bookhub.domain.exception.BookNotFoundException;
import com.bookhub.domain.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookModel, Long> {

    default BookModel findByIdOrThrowException(Long bookId) {
        return this.findById(bookId).orElseThrow(() -> new BookNotFoundException(bookId));
    }
}
