package com.zaalima.engine;

import java.util.TreeMap;
import java.util.Collections;

public class OrderBook {

    private String symbol;
    private TreeMap<Double, PriceLevel> buyOrders;
    private TreeMap<Double, PriceLevel> sellOrders;

    public OrderBook(String symbol) {
        this.symbol = symbol;
        this.buyOrders = new TreeMap<>(Collections.reverseOrder());
        this.sellOrders = new TreeMap<>();
    }

    public void addOrder(Order order) {
        if (order.getSide().equals("BUY")) {
            buyOrders.computeIfAbsent(
                order.getPrice(),
                k -> new PriceLevel(order.getPrice())
            ).addOrder(order);
        } else {
            sellOrders.computeIfAbsent(
                order.getPrice(),
                k -> new PriceLevel(order.getPrice())
            ).addOrder(order);
        }
    }

    public TreeMap<Double, PriceLevel> getBuyOrders() {
        return buyOrders;
    }

    public TreeMap<Double, PriceLevel> getSellOrders() {
        return sellOrders;
    }

    public String getSymbol() {
        return symbol;
    }
}
