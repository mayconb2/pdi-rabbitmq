package com.abinbev.bees.pdiservice.service;

import com.abinbev.bees.pdiservice.domain.Message;
import com.abinbev.bees.pdiservice.dto.MessageDTO;
import com.abinbev.bees.pdiservice.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

    private final MessageRepository repository;

    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }

    public List<MessageDTO> findAll() {
        List<MessageDTO> listDtos = new ArrayList<>();
        List<Message> all = repository.findAll();
        if(!all.isEmpty()) {
            all.forEach(message -> listDtos.add(message.toDTO()));
        }
        return listDtos;
    }
}
