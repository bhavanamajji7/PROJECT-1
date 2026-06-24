# Order Matching Engine

## Overview

Order Matching Engine is a Java-based project that simulates the core functionality of a stock exchange order book. It manages buy and sell orders, validates incoming orders, organizes orders by price levels, and provides supporting components for resilience, monitoring, persistence, and market data streaming.

## Features

* Order Book Management
* Buy and Sell Order Handling
* Price Level Management
* Order Validation
* Order Queue Processing
* Rate Limiting
* Circuit Breaker Support
* Backpressure Handling
* Load Balancing
* Market Data Streaming
* Order Book Snapshots
* Data Persistence
* Monitoring and Alerting

## Project Structure

src/main/java/com/zaalima/engine

* Order.java
* PriceLevel.java
* OrderBook.java
* OrderValidator.java
* OrderQueue.java
* BackpressureHandler.java
* RateLimiter.java
* CircuitBreaker.java
* LoadBalancer.java
* MarketDataStream.java
* OrderBookSnapshot.java
* StreamHandler.java
* DataPersistence.java
* MonitoringHooks.java
* JMXConfig.java
* AlertSystem.java

src/test/java/com/zaalima/engine

* OrderBookTest.java
* OrderValidatorTest.java
* ResilienceTest.java
* SnapshotTest.java

## Technologies Used

* Java 17
* Maven
* JUnit 5
* Collections Framework
* TreeMap
* Queue API

## Core Components

### Order

Represents a buy or sell order with:

* Order ID
* Symbol
* Price
* Quantity
* Side (BUY/SELL)
* Timestamp

### PriceLevel

Groups orders at the same price level using FIFO processing.

### OrderBook

Maintains:

* Buy Orders (Descending Price Priority)
* Sell Orders (Ascending Price Priority)

### OrderValidator

Validates incoming orders before processing.

### OrderQueue

Provides queue-based order buffering.

### Resilience Components

* BackpressureHandler
* RateLimiter
* CircuitBreaker

### Monitoring Components

* MonitoringHooks
* JMXConfig
* AlertSystem

## Running Tests


mvn test


## Build Project


mvn clean install


## Future Enhancements

* Matching Engine
* Trade Execution
* Partial Fills
* Order Cancellation
* Order Modification
* REST APIs using Spring Boot
* MySQL Integration
* Kafka Integration
* Real-time Market Data Streaming

## Author

Nitin Yadav

Feature Branch:
feature/nitin
