package com.abinbev.bees.pdiproducer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class MessageRabbitmqSender {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public MessageRabbitmqSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.routingkey}")
    private String routingkey;

    public void send(@RequestBody String message) {
        System.out.println("sending message...");
        rabbitTemplate.convertAndSend(exchange, routingkey, message);
        System.out.println("message sended: " + message);
    }

}
