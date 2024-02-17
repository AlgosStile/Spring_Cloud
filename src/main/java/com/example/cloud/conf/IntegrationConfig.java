package com.example.cloud.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.messaging.MessageChannel;

import java.io.File;

/**
 * Конфигурация Spring Integration для обработки сообщений.
 */
@Configuration
@EnableIntegration
public class IntegrationConfig {

    @Value("${user.requests.filepath}")
    private String filePath;

    /**
     * Создает канал для передачи сообщений.
     *
     * @return Канал для передачи сообщений.
     */
    @Bean
    public MessageChannel fileWriterChannel() {
        return new DirectChannel();
    }
    /**
     * Создает обработчик сообщений, который записывает их в файл.
     *
     * @return Обработчик сообщений.
     */
    @Bean
    @ServiceActivator(inputChannel = "fileWriterChannel")
    public FileWritingMessageHandler fileWritingMessageHandler() {
        FileWritingMessageHandler handler = new FileWritingMessageHandler(new File(filePath));
        handler.setFileExistsMode(FileExistsMode.APPEND);
        handler.setExpectReply(false);
        return handler;
    }
}
