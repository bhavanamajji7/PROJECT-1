package com.zaalima.engine;

public enum OrderSide {
    BUY,
    SELL;

    public boolean isBuy() {
        return this == BUY;
    }

    public boolean isSell() {
        return this == SELL;
    }

    @Override
    public String toString() {
        return this == BUY ? "BUY" : "SELL";
    }
}
