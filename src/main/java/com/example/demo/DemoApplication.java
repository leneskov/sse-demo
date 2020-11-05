package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entities.Stock;
import java.util.List;


import static com.example.demo.utils.DemoUtils.createRandomStock;
import static com.example.demo.utils.DemoUtils.getStockList;

@SpringBootApplication
public class DemoApplication {

    /**
     * Setting up stockList on app-start
     */
    @Bean
    CommandLineRunner commandLineRunner() {
        List<Stock> stockList = getStockList();
        return args -> {
            createRandomStock();
            stockList.forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
