package com.zaalima.engine;

public class MarketDataTest {

    public static void main(String[] args) {

        MarketData data = new MarketData(
            "AAPL",
            150.00,
            150.50,
            500,
            300
        );

        System.out.println("Symbol: " + data.getSymbol());
        System.out.println("Bid Price: " + data.getBidPrice());
        System.out.println("Ask Price: " + data.getAskPrice());
        System.out.println("Bid Quantity: " + data.getBidQuantity());
        System.out.println("Ask Quantity: " + data.getAskQuantity());
        System.out.println("Timestamp: " + data.getTimestamp());
        System.out.println(data.toString());

        System.out.println("MarketDataTest passed!");
    }
}
