package com.abinbev.bees.pdiconsumer.services;

import com.abinbev.bees.pdiconsumer.domain.Message;
import com.abinbev.bees.pdiconsumer.dto.MessageDTO;
import com.abinbev.bees.pdiconsumer.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

    private final MessageRepository repository;

    @Autowired
    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }

    public Message writeInMongo(MessageDTO message) {
        return repository.save(message.toEntity());
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
