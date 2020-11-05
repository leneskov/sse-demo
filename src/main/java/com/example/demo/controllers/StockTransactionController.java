package com.example.demo.controllers;

import com.example.demo.entities.StockTransaction;
import com.example.demo.services.StockTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


/**
 * This API will return a response with the header Content-Type: application/stream+json.
 * */
@RestController
@RequestMapping("/stock/transaction")
public class StockTransactionController {
    @Autowired
    StockTransactionService stockTransactionService;

    @GetMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE) //This signifies that the server will send SSE.
    public Flux<StockTransaction> stockTransactionEvents() {
        return stockTransactionService.getStockTransactions();
    }
}
