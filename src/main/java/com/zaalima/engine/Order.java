package com.zaalima.engine;

public class Order {

    private String orderId;
    private String symbol;
    private double price;
    private long quantity;
    private String side;
    private long timestamp;

    public Order(String orderId, String symbol,
                 double price, long quantity,
                 String side) {
        this.orderId = orderId;
        this.symbol = symbol;
        this.price = price;
        this.quantity = quantity;
        this.side = side;
        this.timestamp = System.currentTimeMillis();
    }

    public String getOrderId() { return orderId; }
    public String getSymbol() { return symbol; }
    public double getPrice() { return price; }
    public long getQuantity() { return quantity; }
    public String getSide() { return side; }
    public long getTimestamp() { return timestamp; }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", symbol='" + symbol + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", side='" + side + '\'' +
                '}';
    }
}