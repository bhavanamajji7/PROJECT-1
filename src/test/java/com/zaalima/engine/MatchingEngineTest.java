package com.zaalima.engine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class MatchingEngineTest {

    private MatchingEngine engine;

    @BeforeEach
    void setUp() {
        engine = new MatchingEngine("BTC");
    }

    @Test
    void testBuyAndSellMatch() {
        Order sellOrder = new Order(
                "S001", "BTC", 50000.0, 10, "SELL");
        Order buyOrder = new Order(
                "B001", "BTC", 50000.0, 10, "BUY");

        engine.processOrder(sellOrder);
        List<Trade> trades = engine.processOrder(buyOrder);

        assertEquals(1, trades.size());
        assertEquals(50000.0, trades.get(0).getPrice());
        assertEquals(10, trades.get(0).getQuantity());
    }

    @Test
    void testNoMatchWhenPriceDiffers() {
        Order sellOrder = new Order(
                "S002", "BTC", 60000.0, 10, "SELL");
        Order buyOrder = new Order(
                "B002", "BTC", 50000.0, 10, "BUY");

        engine.processOrder(sellOrder);
        List<Trade> trades = engine.processOrder(buyOrder);

        assertEquals(0, trades.size());
    }

    @Test
    void testPartialMatch() {
        Order sellOrder = new Order(
                "S003", "BTC", 50000.0, 5, "SELL");
        Order buyOrder = new Order(
                "B003", "BTC", 50000.0, 10, "BUY");

        engine.processOrder(sellOrder);
        List<Trade> trades = engine.processOrder(buyOrder);

        assertEquals(1, trades.size());
        assertEquals(5, trades.get(0).getQuantity());
    }
}