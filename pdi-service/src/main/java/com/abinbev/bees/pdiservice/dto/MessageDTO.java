package com.abinbev.bees.pdiservice.dto;

import com.abinbev.bees.pdiservice.domain.Message;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonSerialize
public class MessageDTO {

    @JsonProperty
    private String message;
    @JsonProperty private String user;

    public Message toEntity() {
        return new Message("", this.getUser(), this.getMessage());
    }

    @Override
    public String toString() {
        return "MessageDTO {" +
                "message='" + message + '\'' +
                ", user='" + user + '\'' +
                '}';
    }
}