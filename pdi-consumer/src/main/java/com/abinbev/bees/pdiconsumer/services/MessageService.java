package com.abinbev.bees.pdiconsumer.services;

import com.abinbev.bees.pdiconsumer.domain.Message;
import com.abinbev.bees.pdiconsumer.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository repository;

    public List<Message> findAll() {
        return repository.findAll();
    }

    public Message createMessage(Message message) {
        return repository.save(message);
    }

}
