package com.zaalima.engine;

import java.util.HashMap;
import java.util.Map;

public class OrderBookStore {
    private final Map<String, OrderBook> store;

    public OrderBookStore() {
        this.store = new HashMap<>();
    }

    public void addOrderBook(String symbol, OrderBook orderBook) {
        store.put(symbol, orderBook);
    }

    public OrderBook getOrderBook(String symbol) {
        return store.get(symbol);
    }

    public boolean contains(String symbol) {
        return store.containsKey(symbol);
    }

    public void remove(String symbol) {
        store.remove(symbol);
    }
}
