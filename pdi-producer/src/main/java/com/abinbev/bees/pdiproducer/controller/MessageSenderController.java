package com.abinbev.bees.pdiproducer.controller;

import com.abinbev.bees.pdiproducer.dto.MessageDTO;
import com.abinbev.bees.pdiproducer.service.MessageRabbitmqSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/messages")
public class MessageSenderController {

    private final MessageRabbitmqSender rabbitmqSender;

    @Autowired
    public MessageSenderController(MessageRabbitmqSender rabbitmqSender) {
        this.rabbitmqSender = rabbitmqSender;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public String publishMessage(@RequestBody MessageDTO message) {
        rabbitmqSender.send(message);
        return "Mensagem encaminhada com sucesso";
    }
}
