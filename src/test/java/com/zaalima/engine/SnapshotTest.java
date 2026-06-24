package com.zaalima.engine;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SnapshotTest {

    @Test
    public void testSnapshotCreation() {

        OrderBook orderBook =
                new OrderBook("AAPL");

        Order buyOrder =
                new Order(
                        "ORD001",
                        "AAPL",
                        150.0,
                        100,
                        "BUY"
                );

        Order sellOrder =
                new Order(
                        "ORD002",
                        "AAPL",
                        151.0,
                        200,
                        "SELL"
                );

        orderBook.addOrder(buyOrder);
        orderBook.addOrder(sellOrder);

        OrderBookSnapshot snapshot =
                new OrderBookSnapshot(
                        orderBook.getBuyOrders(),
                        orderBook.getSellOrders()
                );

        assertNotNull(snapshot);
    }

    @Test
    public void testSnapshotContainsOrders() {

        OrderBook orderBook =
                new OrderBook("INFY");

        Order order =
                new Order(
                        "ORD003",
                        "INFY",
                        2000.0,
                        50,
                        "BUY"
                );

        orderBook.addOrder(order);

        OrderBookSnapshot snapshot =
                new OrderBookSnapshot(
                        orderBook.getBuyOrders(),
                        orderBook.getSellOrders()
                );

        assertEquals(
                1,
                snapshot.getBuys().size()
        );

        assertEquals(
                0,
                snapshot.getSells().size()
        );
    }
}
