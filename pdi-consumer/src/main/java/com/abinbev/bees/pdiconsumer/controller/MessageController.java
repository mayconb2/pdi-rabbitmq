package com.abinbev.bees.pdiconsumer.controller;

import com.abinbev.bees.pdiconsumer.dto.MessageDTO;
import com.abinbev.bees.pdiconsumer.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/messages")
public class MessageController {

    private final MessageService service;

    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public MessageController(MessageService service, SimpMessagingTemplate messagingTemplate) {
        this.service = service;
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/sendMessage")
    public void receiveMessage(@Payload MessageDTO messageDTO) {
        // receive message from client
    }

    @PostMapping("/send")
    public ResponseEntity<Void> sendMessage(@RequestBody MessageDTO messageDTO) {
        messagingTemplate.convertAndSend("/topic/message", messageDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @SendTo("/topic/message")
    public MessageDTO broadcastMessage(@Payload MessageDTO messageDTO) {
        return messageDTO;
    }

    @GetMapping(value = "getAllMessages")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<MessageDTO> getAllMessages() {
        return this.service.findAll();
    }

}
