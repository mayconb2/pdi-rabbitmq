package com.abinbev.bees.pdiconsumer.service;

import com.abinbev.bees.pdiconsumer.dto.MessageDTO;
import com.abinbev.bees.pdiconsumer.repository.MessageRepository;
import com.abinbev.bees.pdiconsumer.services.MessageService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MessageServiceTest {

    @InjectMocks
    MessageService messageService;

    @Mock
    MessageRepository repository;

    @Test
    void shouldCallMessageRepositoryWhenCallMessageService() {
        MessageDTO message = new MessageDTO("message test","UserTest");

        this.messageService.writeInMongo(message);

        verify(repository).save(message.toEntity());
    }

}
