package com.zaalima.engine;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class LoadBalancer {

    private final AtomicInteger counter =
            new AtomicInteger();

    public String nextServer(
            List<String> servers) {

        int index =
                Math.abs(counter.getAndIncrement());

        return servers.get(
                index % servers.size());
    }
}
