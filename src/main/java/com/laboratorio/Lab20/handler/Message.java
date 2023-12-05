package com.laboratorio.Lab20.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Message {
    private String message;

    public Message(String errorMessage) {
        this.message = errorMessage;
    }


}
