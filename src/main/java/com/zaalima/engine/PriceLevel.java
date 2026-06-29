package com.zaalima.engine;

import java.util.LinkedList;
import java.util.Queue;

public class PriceLevel {
    private double price;
    private Queue<Order> orders;

    public PriceLevel(double price) {
        this.price = price;
        this.orders = new LinkedList<>();
    }

    public void addOrder(Order order) {
        orders.offer(order);
    }

    public Order removeOrder() {
        return orders.poll();
    }

    public Order getFirstOrder() {
        return orders.peek();
    }

    public Order removeFirstOrder() {
        return orders.poll();
    }

    public Queue<Order> getOrders() {
        return orders;
    }

    public double getPrice() {
        return price;
    }

    public boolean isEmpty() {
        return orders.isEmpty();
    }

    public int size() {
        return orders.size();
    }
}