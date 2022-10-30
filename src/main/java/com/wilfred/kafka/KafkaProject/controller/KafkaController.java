package com.wilfred.kafka.KafkaProject.controller;

import com.wilfred.kafka.KafkaProject.component.WilfredTopicConsumer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class KafkaController {
    private KafkaTemplate<String, String> kafkaTemplate;
    private WilfredTopicConsumer wilfredTopicConsumer;

    public KafkaController(KafkaTemplate<String, String> kafkaTemplate, WilfredTopicConsumer wilfredTopicConsumer) {
        this.kafkaTemplate = kafkaTemplate;
        this.wilfredTopicConsumer = wilfredTopicConsumer;
    }

    @GetMapping("/kafka/produce")
    public void produce(@RequestParam("message") String message) {
        System.out.println("message:::::::::::::: " + message);
        kafkaTemplate.send("wilfredTopic", message);
    }

    @GetMapping("/kafka/messages")
    public List<String> getMessages() {
        return wilfredTopicConsumer.getMessages();
    }
}
