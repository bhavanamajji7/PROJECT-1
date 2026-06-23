package com.zaalima.engine;

public class TradeProto {

    private String tradeId;
    private String symbol;
    private double price;
    private long quantity;
    private long timestamp;

    public TradeProto(String tradeId, String symbol, double price, long quantity) {
        this.tradeId = tradeId;
        this.symbol = symbol;
        this.price = price;
        this.quantity = quantity;
        this.timestamp = System.currentTimeMillis();
    }

    public String getTradeId() { return tradeId; }
    public String getSymbol() { return symbol; }
    public double getPrice() { return price; }
    public long getQuantity() { return quantity; }
    public long getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        return "TradeProto{" +
            "tradeId='" + tradeId + '\'' +
            ", symbol='" + symbol + '\'' +
            ", price=" + price +
            ", quantity=" + quantity +
            '}';
    }
}
