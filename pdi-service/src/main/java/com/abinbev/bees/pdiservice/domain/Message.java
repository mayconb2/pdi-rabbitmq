package com.abinbev.bees.pdiservice.domain;

import com.abinbev.bees.pdiservice.dto.MessageDTO;
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

    public MessageDTO toDTO() {
        return new MessageDTO(this.message, this.user);
    }
}
