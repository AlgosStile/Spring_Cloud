package com.example.cloud.conf;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class SingletonBean {

    private static SingletonBean instance;

    private SingletonBean() {}

    @PostConstruct
    public void init() {
        instance = this;
    }

    public static SingletonBean getInstance() {
        return instance;
    }
}
