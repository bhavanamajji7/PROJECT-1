package com.zaalima.engine;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderBookTest {

    @Test
    void testAddBuyOrder() {

        OrderBook book =
                new OrderBook("AAPL");

        Order order =
                new Order(
                        "1",
                        "AAPL",
                        150,
                        100,
                        "BUY");

        book.addOrder(order);

        assertEquals(
                1,
                book.getBuyOrders().size());
    }
}
