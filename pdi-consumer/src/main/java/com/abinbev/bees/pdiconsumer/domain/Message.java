package com.abinbev.bees.pdiconsumer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "messages-rabbitmq")
public class Message {

    @Id
    private String id;
    private String user;
    private String message;

}
