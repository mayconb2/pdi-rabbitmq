package com.abinbev.bees.pdiconsumer.services;

import com.abinbev.bees.pdiconsumer.config.RabbitmqConfig;
import com.abinbev.bees.pdiconsumer.dto.MessagePostDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CustomMessageListner {

    @Value("${rabbitmq.queue}")
    String queueName;

    private static final Logger log = LoggerFactory.getLogger(CustomMessageListner.class);

    @RabbitListener(queues = RabbitmqConfig.QUEUE_NAME)
    public void recieveMessage(final MessagePostDTO message) {
        log.info("The message recivied is: " + message.toString());

    }



}
