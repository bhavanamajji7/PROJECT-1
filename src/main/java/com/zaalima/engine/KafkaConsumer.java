package com.zaalima.engine;

import java.util.ArrayList;
import java.util.List;

public class KafkaConsumer {

    private String topic;
    private List<String> receivedMessages;

    public KafkaConsumer(String topic) {
        this.topic = topic;
        this.receivedMessages = new ArrayList<>();
    }

    public void consume(String message) {
        receivedMessages.add(message);
        System.out.println("Consumed from " + topic + ": " + message);
    }


cat > src/main/java/com/zaalima/engine/KafkaConsumer.java << 'EOF'
package com.zaalima.engine;

import java.util.ArrayList;
import java.util.List;

public class KafkaConsumer {

    private String topic;
    private List<String> receivedMessages;

    public KafkaConsumer(String topic) {
        this.topic = topic;
        this.receivedMessages = new ArrayList<>();
    }

    public void consume(String message) {
        receivedMessages.add(message);
        System.out.println("Consumed from " + topic + ": " + message);
    }

    public List<String> getReceivedMessages() {
        return receivedMessages;
    }

    public String getTopic() {
        return topic;
    }

    @Override
    public String toString() {
        return "KafkaConsumer{topic='" + topic + "', received=" + receivedMessages.size() + "}";
    }
}
