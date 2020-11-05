package com.example.demo.utils;

import com.example.demo.entities.Stock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Helper methods to produce random results for our API
 * */
public class DemoUtils {

    private static List<Stock> stockList = new ArrayList<>();
    private static List<String> stockNames = Arrays.asList("mango,banana,guava,infinity".split(","));

    public static List<Stock> getStockList() {
        return stockList;
    }

    public static void createRandomStock() {
        stockNames.forEach(stockName -> {
            stockList.add(new Stock(stockName, generateRandomStockPrice()));
        });
    }

    public static float generateRandomStockPrice() {
        float min = 30;
        float max = 50;
        return min + roundFloat(new Random().nextFloat() * (max - min));
    }

    public static float changePrice(float price) {
        return roundFloat(Math.random() >= 0.5 ? price * 1.05f : price * 0.95f);
    }

   public static String getRandomUser() {
        String users[] = "adam,tom,john,mike,bill,tony".split(",");
        return users[new Random().nextInt(users.length)];
    }

    public static Stock getRandomStock() {
        return stockList.get(new Random().nextInt(stockList.size()));
    }

     public static float roundFloat(float number) {
        return Math.round(number * 100.0) / 100.0f;
    }
}
