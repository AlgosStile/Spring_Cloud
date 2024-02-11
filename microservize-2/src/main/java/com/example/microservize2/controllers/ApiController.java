package com.example.microservize2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/serviceB")
public class ApiController {

    @GetMapping("/hello")
    public String hello() {
        return "Приветствую! Вы в приложении: App-2";
    }
}
