package com.zaalima.engine;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IntegrationTest {

    @Test
    public void testFullTradeFlowThroughKafkaAndProto() {
        KafkaProducer producer = new KafkaProducer("trades-topic");
        KafkaConsumer consumer = new KafkaConsumer("trades-topic");
        MessageHandler handler = new MessageHandler(consumer);
        SchemaRegistry registry = new SchemaRegistry();

        TradeProto trade = new TradeProto("trd100", "AAPL", 152.25, 50);
        String payload = trade.getTradeId() + "," + trade.getSymbol() + ","
            + trade.getPrice() + "," + trade.getQuantity();

        EventSchema event = new EventSchema("evt100", "TRADE", payload);
        producer.send(event.toMessage());

        String message = producer.getMessages().get(0);
        consumer.consume(message);
        handler.handle(message);

        assertEquals(1, consumer.getReceivedMessages().size());
        assertTrue(registry.isRegistered("TRADE"));
        assertEquals("TradeProto", registry.getSchemaFor("TRADE"));
    }

    @Test
    public void testFullOrderFlowThroughKafkaAndProto() {
        KafkaProducer producer = new KafkaProducer("orders-topic");
        KafkaConsumer consumer = new KafkaConsumer("orders-topic");
        MessageHandler handler = new MessageHandler(consumer);
        SchemaRegistry registry = new SchemaRegistry();

        OrderProto order = new OrderProto("ord100", "MSFT", "BUY", 305.5, 30);
        String payload = order.getOrderId() + "," + order.getSymbol() + ","
            + order.getSide() + "," + order.getPrice() + "," + order.getQuantity();

        EventSchema event = new EventSchema("evt101", "ORDER", payload);
        producer.send(event.toMessage());

        String message = producer.getMessages().get(0);
        consumer.consume(message);
        handler.handle(message);

        assertEquals(1, consumer.getReceivedMessages().size());
        assertTrue(registry.isRegistered("ORDER"));
        assertEquals("OrderProto", registry.getSchemaFor("ORDER"));
    }

    @Test
    public void testMarketDataIntegration() {
        MarketData data = new MarketData("AAPL", 150.0, 150.5, 100, 80);

        assertEquals("AAPL", data.getSymbol());
        assertTrue(data.getAskPrice() > data.getBidPrice());
    }
}
