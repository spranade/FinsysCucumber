package com.springkafkatest.service;

public class KafkaBrokerTest {

    public static void main(String[] args){
        Producer.produce("Hello World","p01720-mask-permission-request");
        Consumer.consume("p01720-mask-permission-response");
    }
}
