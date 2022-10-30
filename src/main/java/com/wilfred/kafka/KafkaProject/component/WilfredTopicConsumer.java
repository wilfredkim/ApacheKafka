package com.wilfred.kafka.KafkaProject.component;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WilfredTopicConsumer {
    // listening to the messages sent to the topic.
    private final List<String> messages = new ArrayList<>();


    @KafkaListener(topics = "wilfredTopic", groupId = "kafka-sandbox")
    public void listen(String message) {
        synchronized (messages) {
            messages.add(message);
        }
    }
    public List<String> getMessages() {
        return messages;
    }
}
