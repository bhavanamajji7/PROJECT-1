package com.zaalima.engine;

import java.util.ArrayList;
import java.util.List;

public class KafkaProducer {

    private String topic;
    private List<String> messages;

    public KafkaProducer(String topic) {
        this.topic = topic;
        this.messages = new ArrayList<>();
    }

    public void send(String message) {
        messages.add(message);
        System.out.println("Sent to " + topic + ": " + message);
    }

    public List<String> getMessages() {
        return messages;
    }

    public String getTopic() {
        return topic;
    }

    @Override
    public String toString() {
        return "KafkaProducer{topic='" + topic + "', messages=" + messages.size() + "}";
    }
}
