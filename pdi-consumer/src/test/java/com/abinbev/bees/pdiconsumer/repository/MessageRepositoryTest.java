package com.abinbev.bees.pdiconsumer.repository;

import com.abinbev.bees.pdiconsumer.domain.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MessageRepositoryTest {

    @Mock
    private MessageRepository repository;

    @Test
    void shouldSaveMessageSuccessfully() {

        Message message = new Message();
        message.setUser("UserTest");
        message.setMessage("message test");

        when(repository.save(message)).then(new Answer<Message>() {
            String id = "123456";

            @Override
            public Message answer(InvocationOnMock invocation) {
                Message savedMessage = invocation.getArgument(0);
                savedMessage.setId(id);
                return savedMessage;
            }
        });

        Message savedMessage = repository.save(message);
        assertNotNull(savedMessage.getId());
        assertEquals(savedMessage, message);
    }
}
