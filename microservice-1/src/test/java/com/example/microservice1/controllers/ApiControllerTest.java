package com.example.microservice1.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ApiController.class)
public class ApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Api Controller Test")
    public void hello_ReturnsHelloMessage() throws Exception {
        mockMvc.perform(get("/serviceA/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Приветствую! Вы в приложении: App-1"));
    }
}
