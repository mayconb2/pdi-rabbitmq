package com.abinbev.bees.pdiproducer.controller;

import com.abinbev.bees.pdiproducer.dto.MessageDTO;
import com.abinbev.bees.pdiproducer.service.MessageRabbitmqSender;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MessageSenderControllerTest {

    @InjectMocks
    private MessageSenderController controller;

    @Mock
    private MessageRabbitmqSender service;

    @Test
    void whenMessageMessageRabbitmqSenderIsCalledShouldCallMessageRabbitmqSender() {
        final MessageDTO dto = new MessageDTO("message test","UserTest");

        controller.publishMessage(dto);
        verify(service, times(1)).send(dto);
    }
}
