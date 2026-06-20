package com.zaalima.engine;

import com.lmax.disruptor.EventHandler;

public class OrderEventHandler
        implements EventHandler<OrderEvent> {

    private MatchingEngine matchingEngine;

    public OrderEventHandler(MatchingEngine matchingEngine) {
        this.matchingEngine = matchingEngine;
    }

    @Override
    public void onEvent(OrderEvent event,
                        long sequence,
                        boolean endOfBatch) {
        Order order = event.getOrder();
        if (order != null) {
            matchingEngine.processOrder(order);
            event.clear();
        }
    }
}