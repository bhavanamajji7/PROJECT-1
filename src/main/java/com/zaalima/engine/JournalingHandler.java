package com.zaalima.engine;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class JournalingHandler {
    private final String logFile;

    public JournalingHandler(String logFile) {
        this.logFile = logFile;
    }

    public void logOrder(Order order) {
        try (FileWriter fw = new FileWriter(logFile, true)) {
            fw.write(LocalDateTime.now() + " | ORDER | " +
                    order.getOrderId() + " | " +
                    order.getSide() + " | " +
                    order.getPrice() + " | " +
                    order.getQuantity() + "\n");
        } catch (IOException e) {
            System.err.println("Journal error: " + e.getMessage());
        }
    }

    public void logTrade(Trade trade) {
        try (FileWriter fw = new FileWriter(logFile, true)) {
            fw.write(LocalDateTime.now() + " | TRADE | " +
                    trade.getBuyOrderId() + " | " +
                    trade.getSellOrderId() + " | " +
                    trade.getPrice() + " | " +
                    trade.getQuantity() + "\n");
        } catch (IOException e) {
            System.err.println("Journal error: " + e.getMessage());
        }
    }
}
