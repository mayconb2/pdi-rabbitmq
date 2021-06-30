package com.abinbev.bees.pdiconsumer.service;

import com.abinbev.bees.pdiconsumer.dto.MessageDTO;
import com.abinbev.bees.pdiconsumer.services.CustomMessageListner;
import com.abinbev.bees.pdiconsumer.services.MessageService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CustomMessageListnerTest {

    @InjectMocks
    CustomMessageListner customMessageListner;

    @Mock
    MessageService messageService;

    @Test
    void shouldCallMessageServiceWhenCustomMessageListnerIsCalled() {

        MessageDTO message = new MessageDTO("message test","UserTest");

        customMessageListner.recieveMessage(message);

        verify(messageService).writeInMongo(message);
    }
}
