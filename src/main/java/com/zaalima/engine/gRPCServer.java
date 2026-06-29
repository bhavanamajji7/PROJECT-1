package com.zaalima.engine;

public class gRPCServer {
    private final int port;
    private boolean running;

    public gRPCServer(int port) {
        this.port = port;
        this.running = false;
    }

    public void start() {
        this.running = true;
        System.out.println("gRPC Server started on port: " + port);
    }

    public void stop() {
        this.running = false;
        System.out.println("gRPC Server stopped.");
    }

    public boolean isRunning() {
        return running;
    }

    public int getPort() {
        return port;
    }
}