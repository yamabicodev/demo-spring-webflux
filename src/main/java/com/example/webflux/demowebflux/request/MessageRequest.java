package com.example.webflux.demowebflux.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageRequest {

    @JsonProperty
    String message;

    public String getMessage() {
        return message;
    }
}
