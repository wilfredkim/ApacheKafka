package com.wilfred.kafka.KafkaProject.jms.receiver;

import org.apache.kafka.clients.consumer.Consumer;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.kafka.support.Acknowledgment;

import javax.jms.*;

public class MyListener implements javax.jms.MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            TextMessage msg = (TextMessage) message;

            System.out.println("following message is received:" + msg.getText());
        } catch (JMSException e) {
            System.out.println(e);
        }
    }
}
