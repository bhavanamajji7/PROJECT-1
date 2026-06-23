package com.zaalima.engine;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProtoTest {

    @Test
    public void testOrderProtoFields() {
        OrderProto order = new OrderProto("ord1", "AAPL", "BUY", 150.5, 10);

        assertEquals("ord1", order.getOrderId());
        assertEquals("AAPL", order.getSymbol());
        assertEquals("BUY", order.getSide());
        assertEquals(150.5, order.getPrice());
        assertEquals(10, order.getQuantity());
        assertTrue(order.getTimestamp() > 0);
    }

    @Test
    public void testTradeProtoFields() {
        TradeProto trade = new TradeProto("trd1", "AAPL", 151.0, 5);

        assertEquals("trd1", trade.getTradeId());
        assertEquals("AAPL", trade.getSymbol());
        assertEquals(151.0, trade.getPrice());
        assertEquals(5, trade.getQuantity());
        assertTrue(trade.getTimestamp() > 0);
    }

    @Test
    public void testOrderProtoToString() {
        OrderProto order = new OrderProto("ord2", "MSFT", "SELL", 300.0, 20);
        String result = order.toString();

        assertTrue(result.contains("ord2"));
        assertTrue(result.contains("MSFT"));
        assertTrue(result.contains("SELL"));
    }

    @Test
    public void testTradeProtoToString() {
        TradeProto trade = new TradeProto("trd2", "MSFT", 299.5, 15);
        String result = trade.toString();

        assertTrue(result.contains("trd2"));
        assertTrue(result.contains("MSFT"));
    }
}
