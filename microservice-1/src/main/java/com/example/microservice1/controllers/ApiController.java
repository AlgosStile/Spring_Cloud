package com.example.microservice1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/serviceA")
public class ApiController {

    @Qualifier("errorChannel")
    @Autowired
    private MessageChannel fileWriterChannel;

    @GetMapping("/hello")
    public String hello() {
        Message<String> message = MessageBuilder.withPayload("User request: /hello").build();
        fileWriterChannel.send(message);
        return "Приветствую! Вы в приложении: App-1";
    }
}

