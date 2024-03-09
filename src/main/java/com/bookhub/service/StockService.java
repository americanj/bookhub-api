package com.bookhub.service;

import com.bookhub.domain.mapper.StockMapper;
import com.bookhub.domain.model.StockModel;
import com.bookhub.domain.vo.StockVo;
import com.bookhub.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private StockMapper stockMapper;


    public StockVo getBook(Long stockId) {
        StockModel stockModel = stockRepository.findByIdOrThrowException(stockId);
        return stockMapper.modelToVo(stockModel);
    }
}
