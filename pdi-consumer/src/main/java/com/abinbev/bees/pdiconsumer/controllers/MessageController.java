package com.abinbev.bees.pdiconsumer.controllers;

import com.abinbev.bees.pdiconsumer.entities.Message;
import com.abinbev.bees.pdiconsumer.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {

    @Autowired
    MessageRepository messageRepository;

    @GetMapping(value = "/messages")
    public List<Message> findAll() {
        return messageRepository.findAll();
    }

}
