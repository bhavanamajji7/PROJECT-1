package com.zaalima.engine;

public class OrderProto {

    private String orderId;
    private String symbol;
    private String side;
    private double price;
    private long quantity;
    private long timestamp;

    public OrderProto(String orderId, String symbol, String side,
                       double price, long quantity) {
        this.orderId = orderId;
        this.symbol = symbol;
        this.side = side;
        this.price = price;
        this.quantity = quantity;
        this.timestamp = System.currentTimeMillis();
    }

    public String getOrderId() { return orderId; }
    public String getSymbol() { return symbol; }
    public String getSide() { return side; }
    public double getPrice() { return price; }
    public long getQuantity() { return quantity; }
    public long getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        return "OrderProto{" +
            "orderId='" + orderId + '\'' +
            ", symbol='" + symbol + '\'' +
            ", side='" + side + '\'' +
            ", price=" + price +
            ", quantity=" + quantity +
            '}';
    }
}
