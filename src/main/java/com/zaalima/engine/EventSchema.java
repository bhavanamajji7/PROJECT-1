package com.zaalima.engine;

public class EventSchema {

    private String eventId;
    private String eventType;
    private String payload;
    private long timestamp;

    public EventSchema(String eventId, String eventType, String payload) {
        this.eventId = eventId;
        this.eventType = eventType;
        this.payload = payload;
        this.timestamp = System.currentTimeMillis();
    }

    public String getEventId() { return eventId; }
    public String getEventType() { return eventType; }
    public String getPayload() { return payload; }
    public long getTimestamp() { return timestamp; }

    public String toMessage() {
        return eventId + "|" + eventType + "|" + timestamp + "|" + payload;
    }

    public static EventSchema fromMessage(String message) {
        if (message == null || message.trim().isEmpty()) {
            throw new IllegalArgumentException("Cannot parse empty or null message");
        }
        String[] parts = message.split("\\|", 4);
        if (parts.length < 4) {
            throw new IllegalArgumentException("Invalid event message format: " + message);
        }
        return new EventSchema(parts[0], parts[1], parts[3]);
    }

    @Override
    public String toString() {
        return "EventSchema{" +
            "eventId='" + eventId + '\'' +
            ", eventType='" + eventType + '\'' +
            ", payload='" + payload + '\'' +
            '}';
    }
}
