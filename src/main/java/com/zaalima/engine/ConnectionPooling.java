package com.zaalima.engine;

import java.util.ArrayDeque;
import java.util.Queue;

public class ConnectionPooling {
    private final int maxSize;
    private final Queue<String> pool;

    public ConnectionPooling(int maxSize) {
        this.maxSize = maxSize;
        this.pool = new ArrayDeque<>();
        for (int i = 1; i <= maxSize; i++) {
            pool.offer("Connection-" + i);
        }
    }

    public String acquireConnection() {
        return pool.poll();
    }

    public void releaseConnection(String connection) {
        if (pool.size() < maxSize) {
            pool.offer(connection);
        }
    }

    public int availableConnections() {
        return pool.size();
    }
}