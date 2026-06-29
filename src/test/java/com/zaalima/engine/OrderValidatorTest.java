package com.zaalima.engine;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderValidatorTest {

    @Test
    void testValidOrder() {

        OrderValidator validator =
                new OrderValidator();

        Order order =
                new Order(
                        "1",
                        "AAPL",
                        150,
                        100,
                        "BUY");

        assertTrue(
                validator.validate(order));
    }
}
