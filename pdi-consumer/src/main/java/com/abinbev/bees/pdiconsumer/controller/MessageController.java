package com.abinbev.bees.pdiconsumer.controller;

import com.abinbev.bees.pdiconsumer.domain.Message;
import com.abinbev.bees.pdiconsumer.services.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/messages")
@RequiredArgsConstructor
public class MessageController {

//    private final MessageService service;
//
//    @GetMapping
//    public List<Message> findAll() {
//        return service.findAll();
//    }

//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public Message createMessage(@RequestBody Message message) {
//        return service.createMessage(message);
//    }

}
