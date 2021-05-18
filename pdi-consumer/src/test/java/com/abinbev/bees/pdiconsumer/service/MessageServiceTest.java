package com.abinbev.bees.pdiconsumer.service;

import com.abinbev.bees.pdiconsumer.domain.Message;
import com.abinbev.bees.pdiconsumer.repository.MessageRepository;
import com.abinbev.bees.pdiconsumer.services.MessageService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


@ExtendWith(MockitoExtension.class)
public class MessageServiceTest {

    @Mock
    MessageRepository repository;

    @InjectMocks
    private MessageService service;

    @Test
    void  whenListMessagesIsCalledThenReturnAListMessages() {
        //given
        Message expectedMessage = new Message("123456789", "teste message");

        //when
        Mockito.when(repository.findAll()).thenReturn(Collections.singletonList(expectedMessage));

        //then
        List<Message> foundedMessages = service.findAll();

        assertThat(foundedMessages, is(not(empty())));
        assertThat(foundedMessages.get(0),is(equalTo(expectedMessage)));
    }
}
