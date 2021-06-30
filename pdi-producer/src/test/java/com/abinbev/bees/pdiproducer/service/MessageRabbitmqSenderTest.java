package com.abinbev.bees.pdiproducer.service;

import com.abinbev.bees.pdiproducer.dto.MessageDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class MessageRabbitmqSenderTest {

    @InjectMocks
    private MessageRabbitmqSender messageRabbitmqSender;

    @Mock
    private RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.routingkey}")
    private String routingkey;

    @Test
    void shouldSendMessageSuccessfully() {
        MessageDTO message = new MessageDTO("message test","UserTest");

        this.messageRabbitmqSender.send(message);

        verify(rabbitTemplate).convertAndSend(exchange, routingkey, message);
    }
}
