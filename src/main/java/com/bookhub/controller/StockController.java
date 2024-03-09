package com.bookhub.controller;

import com.bookhub.domain.mapper.StockMapper;
import com.bookhub.domain.response.StockResponse;
import com.bookhub.domain.vo.StockVo;
import com.bookhub.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    @Autowired
    private StockMapper stockMapper;


    @GetMapping("/{stockId}")
    @ResponseStatus(HttpStatus.OK)
    public StockResponse getStock(@PathVariable Long stockId) {
        StockVo stockVo = stockService.getBook(stockId);
        return stockMapper.voToResponse(stockVo);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<StockResponse> getStocks() {
        List<StockVo> stockVos = stockService.getBooks();
        return stockMapper.vosToResponses(stockVos);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public StockResponse toCreateStock(@RequestParam Integer quantity, @RequestParam Boolean active) {
        StockVo stockVo = stockService.toCreateStock(quantity, active);
        return stockMapper.voToResponse(stockVo);
    }
}
