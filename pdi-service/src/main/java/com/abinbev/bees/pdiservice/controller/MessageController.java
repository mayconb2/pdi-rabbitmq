package com.abinbev.bees.pdiservice.controller;

import com.abinbev.bees.pdiservice.dto.MessageDTO;
import com.abinbev.bees.pdiservice.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "getAllMessages")
    public List<MessageDTO> getAllMessages() {
        return this.messageService.findAll();
    }
}
