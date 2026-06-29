package com.zaalima.engine;

public class MonitoringHooks {

    public void recordMetric(
            String metric,
            double value) {

        System.out.println(
                metric + " = " + value);
    }
}
