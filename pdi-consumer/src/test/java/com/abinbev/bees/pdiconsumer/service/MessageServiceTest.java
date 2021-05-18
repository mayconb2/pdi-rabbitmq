package com.abinbev.bees.pdiconsumer.service;

import com.abinbev.bees.pdiconsumer.domain.Message;
import com.abinbev.bees.pdiconsumer.services.MessageService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class MessageServiceTest {

    @InjectMocks
    private MessageService service;

    @Test
    private List<Message> whenListMessagesIsCalledThenReturnAListMessages() {
        //given


        //when



        //then
        return new ArrayList<Message>();
    }
}
