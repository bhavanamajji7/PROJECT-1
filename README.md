# Zalima Project 1 - Trading Engine

A simplified trading engine simulation built in Java, covering core trading concepts (trades, orders, market data), a mock event-streaming pipeline (Kafka-style), and Protobuf-style message schemas.

## Overview

This project simulates a basic trading system pipeline:

1. Core domain models - Trade, MarketData, OrderSide, PriceLevel
2. Event streaming - A mock Kafka producer/consumer pipeline that passes events as strings
3. Schema layer - EventSchema for generic event wrapping, plus Protobuf-style message definitions (OrderProto, TradeProto)
4. Testing - Unit tests, integration tests, and performance tests covering the full pipeline

## Project Structure

### Week 1 - Core Domain Models
- Trade.java, TradeTest.java, MarketData.java, MarketDataTest.java, OrderSide.java

### Week 2 - Event Streaming Pipeline
- KafkaProducer.java, KafkaConsumer.java, EventSchema.java, MessageHandler.java, KafkaTest.java

### Week 3 - Protobuf-style Schemas
- ProtobufSchema.proto, OrderProto.java, TradeProto.java, ProtoTest.java, SchemaRegistry.java

### Week 4 - Testing and Polish
- IntegrationTest.java, PerformanceTest.java, README.md

## How It Works

TradeProto / OrderProto data flows into EventSchema, which wraps it with metadata. KafkaProducer sends the message, KafkaConsumer receives it, and MessageHandler routes it based on event type.

## Running the Tests

Run mvn test to execute all unit, integration, and performance tests.

## Notes

KafkaProducer and KafkaConsumer are simplified, in-memory mocks for learning purposes. They do not connect to a real Kafka broker.
