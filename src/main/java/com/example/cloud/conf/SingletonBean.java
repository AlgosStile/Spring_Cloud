package com.example.cloud.conf;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

/**
 * Singleton-класс, предоставляющий доступ к единственному экземпляру себя.
 */
@Component
public class SingletonBean {

    private static SingletonBean instance;

    private SingletonBean() {
    }
    /**
     * Инициализирует единственный экземпляр класса.
     */
    @PostConstruct
    public void init() {
        instance = this;
    }
    /**
     * Возвращает единственный экземпляр класса.
     *
     * @return Единственный экземпляр класса.
     */
    public static SingletonBean getInstance() {
        return instance;
    }
}
