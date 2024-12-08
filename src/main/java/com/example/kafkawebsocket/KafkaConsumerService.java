package com.example.kafkawebsocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    @Autowired
    private SimpMessagingTemplate template;

    @KafkaListener(topics = "topic1234", groupId = "my-group")
    public void listen(String message) {
        template.convertAndSend("/topic/messages", message);
    }
}
