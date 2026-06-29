package com.zaalima.engine;

public class MonitoringHooks {
    private long totalOrders;
    private long totalTrades;
    private long startTime;

    public MonitoringHooks() {
        this.startTime = System.currentTimeMillis();
    }

    public void recordOrder() {
        totalOrders++;
    }

    public void recordTrade() {
        totalTrades++;
    }

    public long getTotalOrders() {
        return totalOrders;
    }

    public long getTotalTrades() {
        return totalTrades;
    }

    public long getUptimeSeconds() {
        return (System.currentTimeMillis() - startTime) / 1000;
    }

    public void printStats() {
        System.out.println("Orders: " + totalOrders);
        System.out.println("Trades: " + totalTrades);
        System.out.println("Uptime: " + getUptimeSeconds() + "s");
    }
}