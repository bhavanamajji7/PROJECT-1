package com.zaalima.engine;

public class JVMConfig {
    public static void printJVMInfo() {
        System.out.println("Java Version: " +
                System.getProperty("java.version"));
        System.out.println("Max Memory: " +
                Runtime.getRuntime().maxMemory() / 1024 / 1024 + " MB");
        System.out.println("Available Processors: " +
                Runtime.getRuntime().availableProcessors());
    }

    public static long getAvailableMemory() {
        return Runtime.getRuntime().freeMemory();
    }

    public static int getProcessors() {
        return Runtime.getRuntime().availableProcessors();
    }
}