package com.company;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Main {

    private static final String EXCHANGE_NAME = "Demo.Dynamic.Scalar.UInt16";
    public static void main(String[] args) throws Exception {

        SubscribeManager subscribeManager = SubscribeManager.getInstance();
        subscribeManager.init("localhost");
        subscribeManager.createChannel(EXCHANGE_NAME, "fanout");

        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        Consumer consumer = new DefaultConsumer(subscribeManager.getChannelFromExchange(EXCHANGE_NAME)) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
            }
        };
        subscribeManager.getChannelFromExchange(EXCHANGE_NAME).basicConsume(subscribeManager.bindToQueue(EXCHANGE_NAME), true, consumer);
    }

}
