package com.zaalima.engine;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.util.DaemonThreadFactory;

public class DisruptorConfig {

    private static final int BUFFER_SIZE = 1024;

    private Disruptor<OrderEvent> disruptor;
    private RingBuffer<OrderEvent> ringBuffer;

    public void start(MatchingEngine engine) {
        disruptor = new Disruptor<>(
                OrderEvent::new,
                BUFFER_SIZE,
                DaemonThreadFactory.INSTANCE
        );

        disruptor.handleEventsWith(
                new OrderEventHandler(engine)
        );

        disruptor.start();
        ringBuffer = disruptor.getRingBuffer();
    }

    public void publishOrder(Order order) {
        long sequence = ringBuffer.next();
        try {
            OrderEvent event = ringBuffer.get(sequence);
            event.setOrder(order);
        } finally {
            ringBuffer.publish(sequence);
        }
    }

    public void stop() {
        disruptor.shutdown();
    }
}