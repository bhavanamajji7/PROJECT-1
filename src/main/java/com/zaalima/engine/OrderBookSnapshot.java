package com.zaalima.engine;

import java.util.TreeMap;

public class OrderBookSnapshot {

    private TreeMap<Double, PriceLevel> buys;
    private TreeMap<Double, PriceLevel> sells;

    public OrderBookSnapshot(
            TreeMap<Double, PriceLevel> buys,
            TreeMap<Double, PriceLevel> sells) {

        this.buys = buys;
        this.sells = sells;
    }

    public TreeMap<Double, PriceLevel> getBuys() {
        return buys;
    }

    public TreeMap<Double, PriceLevel> getSells() {
        return sells;
    }
}
