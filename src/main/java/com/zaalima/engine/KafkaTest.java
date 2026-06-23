package com.zaalima.engine;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KafkaTest {

    @Test
    public void testProducerSendsMessage() {
        KafkaProducer producer = new KafkaProducer("trades-topic");
        producer.send("hello");
        assertEquals(1, producer.getMessages().size());
        assertEquals("hello", producer.getMessages().get(0));
    }

    @Test
    public void testConsumerReceivesMessage() {
        KafkaConsumer consumer = new KafkaConsumer("trades-topic");
        consumer.consume("hello");
        assertEquals(1, consumer.getReceivedMessages().size());
        assertEquals("hello", consumer.getReceivedMessages().get(0));
    }

    @Test
    public void testEventSchemaRoundTrip() {
        EventSchema event = new EventSchema("evt1", "TRADE", "AAPL,100,150.5");
        String message = event.toMessage();

        EventSchema parsed = EventSchema.fromMessage(message);
        assertEquals("evt1", parsed.getEventId());
        assertEquals("TRADE", parsed.getEventType());
        assertEquals("AAPL,100,150.5", parsed.getPayload());
    }

    @Test
    public void testFullPipelineProducerToHandler() {
        KafkaProducer producer = new KafkaProducer("trades-topic");
        KafkaConsumer consumer = new KafkaConsumer("trades-topic");
        MessageHandler handler = new MessageHandler(consumer);

        EventSchema event = new EventSchema("evt2", "ORDER", "BUY,AAPL,10");
        producer.send(event.toMessage());

        String message = producer.getMessages().get(0);
        consumer.consume(message);
        handler.handle(message);

        assertEquals(1, consumer.getReceivedMessages().size());
    }
}
