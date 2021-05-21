package com.abinbev.bees.pdiproducer.controller;

import com.abinbev.bees.pdiproducer.service.MessageRabbitmqSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/messages")
public class MessageSenderController {

    private final MessageRabbitmqSender rabbitmqSender;

    @Autowired
    public MessageSenderController(MessageRabbitmqSender rabbitmqSender) {
        this.rabbitmqSender = rabbitmqSender;
    }

    @PostMapping
    public String publishMessage(@RequestBody String message) {
        rabbitmqSender.send(message);
        return "Mensagem encaminhada com sucesso";
    }
}
