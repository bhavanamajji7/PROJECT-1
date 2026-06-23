package com.zaalima.engine;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PerformanceTest {

    private static final int MESSAGE_COUNT = 10000;

    @Test
    public void testProducerThroughput() {
        KafkaProducer producer = new KafkaProducer("perf-topic");

        long start = System.currentTimeMillis();
        for (int i = 0; i < MESSAGE_COUNT; i++) {
            producer.send("message-" + i);
        }
        long elapsed = System.currentTimeMillis() - start;

        assertEquals(MESSAGE_COUNT, producer.getMessages().size());
        System.out.println("Produced " + MESSAGE_COUNT + " messages in " + elapsed + " ms");
        assertTrue(elapsed < 5000, "Producer took too long: " + elapsed + " ms");
    }

    @Test
    public void testConsumerThroughput() {
        KafkaConsumer consumer = new KafkaConsumer("perf-topic");

        long start = System.currentTimeMillis();
        for (int i = 0; i < MESSAGE_COUNT; i++) {
            consumer.consume("message-" + i);
        }
        long elapsed = System.currentTimeMillis() - start;

        assertEquals(MESSAGE_COUNT, consumer.getReceivedMessages().size());
        System.out.println("Consumed " + MESSAGE_COUNT + " messages in " + elapsed + " ms");
        assertTrue(elapsed < 5000, "Consumer took too long: " + elapsed + " ms");
    }

    @Test
    public void testFullPipelineThroughput() {
        KafkaProducer producer = new KafkaProducer("perf-topic");
        KafkaConsumer consumer = new KafkaConsumer("perf-topic");
        MessageHandler handler = new MessageHandler(consumer);

        long start = System.currentTimeMillis();
        for (int i = 0; i < MESSAGE_COUNT; i++) {
            EventSchema event = new EventSchema("evt" + i, "TRADE", "AAPL,100,150.0");
            String message = event.toMessage();
            producer.send(message);
            consumer.consume(message);
            handler.handle(message);
        }
        long elapsed = System.currentTimeMillis() - start;

        assertEquals(MESSAGE_COUNT, consumer.getReceivedMessages().size());
        System.out.println("Full pipeline processed " + MESSAGE_COUNT + " events in " + elapsed + " ms");
        assertTrue(elapsed < 10000, "Pipeline took too long: " + elapsed + " ms");
    }
}
