package com.zaalima.engine;

import java.util.List;
import java.util.ArrayList;

public class OrderServiceImpl {
    private final MatchingEngine matchingEngine;
    private final List<Trade> trades;

    public OrderServiceImpl(MatchingEngine matchingEngine) {
        this.matchingEngine = matchingEngine;
        this.trades = new ArrayList<>();
    }

    public List<Trade> submitOrder(Order order) {
        List<Trade> result = matchingEngine.processOrder(order);
        trades.addAll(result);
        return result;
    }

    public List<Trade> getAllTrades() {
        return trades;
    }
}