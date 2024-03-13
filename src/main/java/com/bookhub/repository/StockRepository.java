package com.bookhub.repository;

import com.bookhub.domain.exception.StockNotFoundException;
import com.bookhub.domain.model.StockModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<StockModel, Long> {

    default StockModel findByIdOrThrowException(Long stockId) {
        return this.findById(stockId).orElseThrow(() -> new StockNotFoundException(stockId));
    }
}



