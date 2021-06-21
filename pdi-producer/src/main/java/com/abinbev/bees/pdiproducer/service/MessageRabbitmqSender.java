package com.abinbev.bees.pdiproducer.service;

import com.abinbev.bees.pdiproducer.dto.MessageDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class MessageRabbitmqSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.routingkey}")
    private String routingkey;

    public void send(@RequestBody MessageDTO message) {
        rabbitTemplate.convertAndSend(exchange, routingkey, message);
    }

}
