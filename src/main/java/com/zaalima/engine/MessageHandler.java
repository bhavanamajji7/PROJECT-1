package com.zaalima.engine;

public class MessageHandler {

    private KafkaConsumer consumer;

    public MessageHandler(KafkaConsumer consumer) {
        this.consumer = consumer;
    }

    public void handle(String message) {
        if (message == null || message.trim().isEmpty()) {
            System.out.println("Skipping empty or null message");
            return;
        }

        EventSchema event;
        try {
            event = EventSchema.fromMessage(message);
        } catch (IllegalArgumentException e) {
            System.out.println("Failed to parse message: " + e.getMessage());
            return;
        }

        switch (event.getEventType()) {
            case "TRADE":
                handleTrade(event);
                break;
            case "ORDER":
                handleOrder(event);
                break;
            default:
                System.out.println("Unknown event type: " + event.getEventType());
        }
    }

    private void handleTrade(EventSchema event) {
        System.out.println("Handling TRADE event: " + event.getPayload());
    }

    private void handleOrder(EventSchema event) {
        System.out.println("Handling ORDER event: " + event.getPayload());
    }

    @Override
    public String toString() {
        return "MessageHandler{consumer=" + consumer + "}";
    }
}
