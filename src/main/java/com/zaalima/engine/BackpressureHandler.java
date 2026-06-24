package com.zaalima.engine;

public class BackpressureHandler {

    private final int maxCapacity;

    public BackpressureHandler(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public boolean canAccept(int currentSize) {
        return currentSize < maxCapacity;
    }
}
