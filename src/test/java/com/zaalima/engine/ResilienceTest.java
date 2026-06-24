package com.zaalima.engine;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ResilienceTest {

    @Test
    public void testCircuitBreakerInitiallyClosed() {

        CircuitBreaker circuitBreaker =
                new CircuitBreaker();

        assertFalse(
                circuitBreaker.isOpen()
        );
    }

    @Test
    public void testCircuitBreakerOpen() {

        CircuitBreaker circuitBreaker =
                new CircuitBreaker();

        circuitBreaker.openCircuit();

        assertTrue(
                circuitBreaker.isOpen()
        );
    }

    @Test
    public void testCircuitBreakerClose() {

        CircuitBreaker circuitBreaker =
                new CircuitBreaker();

        circuitBreaker.openCircuit();
        circuitBreaker.closeCircuit();

        assertFalse(
                circuitBreaker.isOpen()
        );
    }

    @Test
    public void testBackpressureHandler() {

        BackpressureHandler handler =
                new BackpressureHandler(10);

        assertTrue(
                handler.canAccept(5)
        );

        assertFalse(
                handler.canAccept(10)
        );
    }

    @Test
    public void testRateLimiter() {

        RateLimiter limiter =
                new RateLimiter();

        assertTrue(
                limiter.allowRequest()
        );
    }
}
