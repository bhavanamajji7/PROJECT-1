package com.zaalima.engine;

public class RateLimiter {

    private long lastRequestTime;

    public synchronized boolean allowRequest()
    {

        long currentTime =
                System.currentTimeMillis();

        if (currentTime - lastRequestTime >= 1000) 
        {

            lastRequestTime = currentTime;

            return true;
        }

        return false;
    }
}
