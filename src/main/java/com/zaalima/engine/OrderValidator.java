package com.zaalima.engine;

public class OrderValidator {

    public boolean validate(Order order) {

        if (order == null)
            return false;

        if (order.getOrderId() == null ||
            order.getOrderId().isEmpty())
            return false;

        if (order.getSymbol() == null ||
            order.getSymbol().isEmpty())
            return false;

        if (order.getPrice() <= 0)
            return false;

        if (order.getQuantity() <= 0)
            return false;

        if (!order.getSide().equals("BUY") &&
            !order.getSide().equals("SELL"))
            return false;

        return true;
    }
}
