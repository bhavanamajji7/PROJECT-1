package com.zaalima.engine;

public class Trade {

    private String tradeId;
    private String buyOrderId;
    private String sellOrderId;
    private String symbol;
    private double price;
    private long quantity;
    private long timestamp;

    public Trade(String tradeId, String buyOrderId,
                 String sellOrderId, String symbol,
                 double price, long quantity) {
        this.tradeId = tradeId;
        this.buyOrderId = buyOrderId;
        this.sellOrderId = sellOrderId;
        this.symbol = symbol;
        this.price = price;
        this.quantity = quantity;
        this.timestamp = System.currentTimeMillis();
    }

    public String getTradeId() { return tradeId; }
    public String getBuyOrderId() { return buyOrderId; }
    public String getSellOrderId() { return sellOrderId; }
    public String getSymbol() { return symbol; }
    public double getPrice() { return price; }
    public long getQuantity() { return quantity; }
    public long getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        return "Trade{" +
            "tradeId='" + tradeId + '\'' +
            ", symbol='" + symbol + '\'' +
            ", price=" + price +
            ", quantity=" + quantity +
            '}';
    }
}
