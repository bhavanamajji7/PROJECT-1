package com.zaalima.engine;

public class EventSchema {

    private String eventId;
    private String eventType;
    private String payload;

    public EventSchema(String eventId, String eventType, String payload) {
        this.eventId = eventId;
        this.eventType = eventType;
        this.payload = payload;
    }

    public String getEventId() {
        return eventId;
    }

    public String getEventType() {
        return eventType;
    }

    public String getPayload() {
        return payload;
    }

    public String toMessage() {
        return eventId + "|" + eventType + "|" + payload;
    }

    public static EventSchema fromMessage(String message) {
        String[] parts = message.split("\\|", 3);
        return new EventSchema(parts[0], parts[1], parts[2]);
    }

    @Override
    public String toString() {
        return "EventSchema{eventId='" + eventId + "', eventType='" + eventType + "', payload='" + payload + "'}";
    }
}
