package com.zaalima.engine;

public class TradeTest {

    public static void main(String[] args) {

        Trade trade = new Trade(
            "T001",
            "B001",
            "S001",
            "AAPL",
            150.50,
            100
        );

        System.out.println("Trade ID: " + trade.getTradeId());
        System.out.println("Buy Order ID: " + trade.getBuyOrderId());
        System.out.println("Sell Order ID: " + trade.getSellOrderId());
        System.out.println("Symbol: " + trade.getSymbol());
        System.out.println("Price: " + trade.getPrice());
        System.out.println("Quantity: " + trade.getQuantity());
        System.out.println("Timestamp: " + trade.getTimestamp());
        System.out.println(trade.toString());


cat > src/main/java/com/zaalima/engine/TradeTest.java << 'EOF'
package com.zaalima.engine;

public class TradeTest {

    public static void main(String[] args) {

        Trade trade = new Trade(
            "T001",
            "B001",
            "S001",
            "AAPL",
            150.50,
            100
        );

        System.out.println("Trade ID: " + trade.getTradeId());
        System.out.println("Buy Order ID: " + trade.getBuyOrderId());
        System.out.println("Sell Order ID: " + trade.getSellOrderId());
        System.out.println("Symbol: " + trade.getSymbol());
        System.out.println("Price: " + trade.getPrice());
        System.out.println("Quantity: " + trade.getQuantity());
        System.out.println("Timestamp: " + trade.getTimestamp());
        System.out.println(trade.toString());

        System.out.println("TradeTest passed!");
    }
}
