package com.zaalima.engine;

import java.util.HashMap;
import java.util.Map;

public class ChronicleMapConfig {
    private final Map<String, Order> orderStore;

    public ChronicleMapConfig() {
        this.orderStore = new HashMap<>();
    }

    public void putOrder(String orderId, Order order) {
        orderStore.put(orderId, order);
    }

    public Order getOrder(String orderId) {
        return orderStore.get(orderId);
    }

    public void removeOrder(String orderId) {
        orderStore.remove(orderId);
    }

    public boolean containsOrder(String orderId) {
        return orderStore.containsKey(orderId);
    }

    public int size() {
        return orderStore.size();
    }
}