package com.abinbev.bees.pdiconsumer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonSerialize
public class MessagePostDTO {

    @JsonProperty
    private String message;
    @JsonProperty private String user;


    @Override
    public String toString() {
        return "MessagePostDTO{" +
                "message='" + message + '\'' +
                ", user='" + user + '\'' +
                '}';
    }
}
