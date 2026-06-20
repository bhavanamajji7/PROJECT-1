package com.zaalima.engine;

import java.util.ArrayList;
import java.util.List;

public class OrderBook {

    private final List<String> orders = new ArrayList<>();

    public void addOrder(String order) {
        orders.add(order);
    }

    public List<String> getOrders() {
        return orders;
    }

    public int size() {
        return orders.size();
    }
}
