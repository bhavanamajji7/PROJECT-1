package com.zaalima.engine;

public class MarketData {

    private String symbol;
    private double bidPrice;
    private double askPrice;
    private long bidQuantity;
    private long askQuantity;
    private long timestamp;

    public MarketData(String symbol, double bidPrice, double askPrice,
                      long bidQuantity, long askQuantity) {
        this.symbol = symbol;
        this.bidPrice = bidPrice;
        this.askPrice = askPrice;
        this.bidQuantity = bidQuantity;
        this.askQuantity = askQuantity;
        this.timestamp = System.currentTimeMillis();
    }

    public String getSymbol() { return symbol; }
    public double getBidPrice() { return bidPrice; }
    public double getAskPrice() { return askPrice; }
    public long getBidQuantity() { return bidQuantity; }
    public long getAskQuantity() { return askQuantity; }
    public long getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        return "MarketData{" +
            "symbol='" + symbol + '\'' +
            ", bidPrice=" + bidPrice +
            ", askPrice=" + askPrice +
            '}';
    }
}
