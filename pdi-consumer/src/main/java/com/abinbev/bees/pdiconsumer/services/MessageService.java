package com.abinbev.bees.pdiconsumer.services;

import com.abinbev.bees.pdiconsumer.domain.Message;
import com.abinbev.bees.pdiconsumer.dto.MessageDTO;
import com.abinbev.bees.pdiconsumer.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository repository;

    public Message writeInMongo(MessageDTO message) {

        return repository.save(message.toEntity());
    }

}
