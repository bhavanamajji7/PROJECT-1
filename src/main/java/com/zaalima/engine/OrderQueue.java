package com.zaalima.engine;

import java.util.LinkedList;
import java.util.Queue;

public class OrderQueue {

    private Queue<Order> queue = new LinkedList<>();

    public void enqueue(Order order) {
        queue.offer(order);
    }

    public Order dequeue() {
        return queue.poll();
    }

    public int size() {
        return queue.size();
    }
}
