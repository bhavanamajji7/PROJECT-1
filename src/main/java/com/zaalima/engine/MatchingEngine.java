package com.zaalima.engine;

import java.util.ArrayList;
import java.util.List;

public class MatchingEngine {

    private OrderBook orderBook;

    public MatchingEngine(String symbol) {
        this.orderBook = new OrderBook(symbol);
    }

    public List<Trade> processOrder(Order order) {
        List<Trade> trades = new ArrayList<>();
        orderBook.addOrder(order);

        if (order.getSide().equals("BUY")) {
            matchBuyOrder(order, trades);
        } else {
            matchSellOrder(order, trades);
        }
        return trades;
    }

    private void matchBuyOrder(Order buyOrder, List<Trade> trades) {
        while (!orderBook.getSellOrders().isEmpty()
                && buyOrder.getQuantity() > 0) {

            double bestSellPrice = orderBook
                    .getSellOrders().firstKey();

            if (buyOrder.getPrice() >= bestSellPrice) {
                PriceLevel sellLevel = orderBook
                        .getSellOrders().get(bestSellPrice);
                Order sellOrder = sellLevel.getFirstOrder();

                long matchQty = Math.min(
                        buyOrder.getQuantity(),
                        sellOrder.getQuantity()
                );

                trades.add(new Trade(
                        "T" + System.currentTimeMillis(),
                        buyOrder.getOrderId(),
                        sellOrder.getOrderId(),
                        buyOrder.getSymbol(),
                        bestSellPrice,
                        matchQty
                ));

                buyOrder.setQuantity(
                        buyOrder.getQuantity() - matchQty);
                sellOrder.setQuantity(
                        sellOrder.getQuantity() - matchQty);

                if (sellOrder.getQuantity() == 0) {
                    sellLevel.removeFirstOrder();
                }
                if (sellLevel.isEmpty()) {
                    orderBook.getSellOrders()
                            .remove(bestSellPrice);
                }
            } else {
                break;
            }
        }
    }

    private void matchSellOrder(Order sellOrder, List<Trade> trades) {
        while (!orderBook.getBuyOrders().isEmpty()
                && sellOrder.getQuantity() > 0) {

            double bestBuyPrice = orderBook
                    .getBuyOrders().firstKey();

            if (sellOrder.getPrice() <= bestBuyPrice) {
                PriceLevel buyLevel = orderBook
                        .getBuyOrders().get(bestBuyPrice);
                Order buyOrder = buyLevel.getFirstOrder();

                long matchQty = Math.min(
                        sellOrder.getQuantity(),
                        buyOrder.getQuantity()
                );

                trades.add(new Trade(
                        "T" + System.currentTimeMillis(),
                        buyOrder.getOrderId(),
                        sellOrder.getOrderId(),
                        sellOrder.getSymbol(),
                        bestBuyPrice,
                        matchQty
                ));

                sellOrder.setQuantity(
                        sellOrder.getQuantity() - matchQty);
                buyOrder.setQuantity(
                        buyOrder.getQuantity() - matchQty);

                if (buyOrder.getQuantity() == 0) {
                    buyLevel.removeFirstOrder();
                }
                if (buyLevel.isEmpty()) {
                    orderBook.getBuyOrders()
                            .remove(bestBuyPrice);
                }
            } else {
                break;
            }
        }
    }
}