package com.zaalima.engine;

import com.lmax.disruptor.EventHandler;

public class RiskValidationHandler
        implements EventHandler<OrderEvent> {

    private static final double MAX_ORDER_VALUE = 1_000_000.0;
    private static final long MAX_QUANTITY = 10_000;

    @Override
    public void onEvent(OrderEvent event,
                        long sequence,
                        boolean endOfBatch) {
        Order order = event.getOrder();
        if (order != null) {
            if (!isValid(order)) {
                event.clear();
            }
        }
    }

    private boolean isValid(Order order) {
        if (order.getQuantity() <= 0) {
            return false;
        }
        if (order.getQuantity() > MAX_QUANTITY) {
            return false;
        }
        if (order.getPrice() <= 0) {
            return false;
        }
        double orderValue = order.getPrice()
                * order.getQuantity();
        if (orderValue > MAX_ORDER_VALUE) {
            return false;
        }
        return true;
    }
}