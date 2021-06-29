package com.abinbev.bees.pdiconsumer.services;

import com.abinbev.bees.pdiconsumer.config.RabbitmqConfig;
import com.abinbev.bees.pdiconsumer.dto.MessageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomMessageListner {

    private final MessageService service;

    private static final Logger log = LoggerFactory.getLogger(CustomMessageListner.class);

    @Autowired
    public CustomMessageListner(MessageService service) {
        this.service = service;
    }

    @RabbitListener(queues = RabbitmqConfig.QUEUE_NAME)
    public void recieveMessage(final MessageDTO message) {
        service.writeInMongo(message);
        log.info("The message recivied is: {}", message);
    }



}
