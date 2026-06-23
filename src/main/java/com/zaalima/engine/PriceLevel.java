package com.zaalima.engine;

import java.util.LinkedList;
import java.util.Queue;

public class PriceLevel {

    private double price;
    private Queue<Order> orders;
    private long totalQuantity;

    public PriceLevel(double price) {
        this.price = price;
        this.orders = new LinkedList<>();
        this.totalQuantity = 0;
    }

    public void addOrder(Order order) {
        orders.add(order);
        totalQuantity += order.getQuantity();
    }



cat > src/main/java/com/zaalima/engine/PriceLevel.java << 'EOF'
package com.zaalima.engine;

import java.util.LinkedList;
import java.util.Queue;

public class PriceLevel {

    private double price;
    private Queue<Order> orders;
    private long totalQuantity;

    public PriceLevel(double price) {
        this.price = price;
        this.orders = new LinkedList<>();
        this.totalQuantity = 0;
    }

    public void addOrder(Order order) {
        orders.add(order);
        totalQuantity += order.getQuantity();
    }

    public Order getFirstOrder() {
        return orders.peek();
    }

    public void removeFirstOrder() {
        Order order = orders.poll();
        if (order != null) {
            totalQuantity -= order.getQuantity();
        }
    }

    public double getPrice() { return price; }
    public long getTotalQuantity() { return totalQuantity; }
    public boolean isEmpty() { return orders.isEmpty(); }

    @Override
    public String toString() {
        return "PriceLevel{" +
            "price=" + price +
            ", totalQuantity=" + totalQuantity +
            '}';
    }
}
