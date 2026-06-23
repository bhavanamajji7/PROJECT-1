package com.zaalima.engine;

public class MessageHandler {

    private KafkaConsumer consumer;

    public MessageHandler(KafkaConsumer consumer) {
        this.consumer = consumer;
    }

    public void handle(String message) {
        EventSchema event = EventSchema.fromMessage(message);

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
