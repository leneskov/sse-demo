package com.example.demo.services;

import com.example.demo.entities.Stock;
import com.example.demo.entities.StockTransaction;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import static com.example.demo.utils.DemoUtils.*;

@Service
public class StockTransactionService {
    public Flux<StockTransaction> getStockTransactions() {
        List<Stock> stockList = getStockList();
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(1));
        interval.subscribe((i) -> stockList.forEach(stock -> stock.setPrice(changePrice(stock.getPrice()))));

        Flux<StockTransaction> stockTransactionFlux = Flux.fromStream(Stream.generate(() ->
                new StockTransaction(getRandomUser(), getRandomStock(), new Date())));
        return Flux.zip(interval, stockTransactionFlux).map(Tuple2::getT2);
    }
}
