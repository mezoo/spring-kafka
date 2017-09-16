package com.mezoo.consumer;

import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

public class MessageListener {

    private CountDownLatch latch = new CountDownLatch(3);

    @KafkaListener(topics = "${message.topic.name}", group = "foo")
    public void listenGroupFoo(String message) {
        System.out.println("Received Message in group 'foo': " + message);
        latch.countDown();
    }

    public CountDownLatch getLatch(){
        return latch;
    }
}
