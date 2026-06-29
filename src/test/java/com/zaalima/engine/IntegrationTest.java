package com.zaalima.engine;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class IntegrationTest {
    private MatchingEngine engine;

    @BeforeEach
    void setUp() {
        engine = new MatchingEngine();
    }

    @Test
    void testFullOrderFlow() {
        Order buy = new Order("B1", "AAPL", "BUY", 150.0, 10);
        Order sell = new Order("S1", "AAPL", "SELL", 150.0, 10);
        engine.processOrder(buy);
        var trades = engine.processOrder(sell);
        assertFalse(trades.isEmpty());
    }
}