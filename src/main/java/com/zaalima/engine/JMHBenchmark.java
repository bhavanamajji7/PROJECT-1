package com.zaalima.engine;

public class JMHBenchmark {
    private final MatchingEngine matchingEngine;

    public JMHBenchmark(MatchingEngine matchingEngine) {
        this.matchingEngine = matchingEngine;
    }

    public void benchmarkOrderProcessing() {
        long start = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            Order order = new Order("ORD-" + i, "AAPL",
                    "BUY", 150.0, 10);
            matchingEngine.processOrder(order);
        }
        long end = System.nanoTime();
        System.out.println("Benchmark: " +
                (end - start) / 1_000_000 + " ms for 100k orders");
    }

    public long measureLatency(Order order) {
        long start = System.nanoTime();
        matchingEngine.processOrder(order);
        return System.nanoTime() - start;
    }
}