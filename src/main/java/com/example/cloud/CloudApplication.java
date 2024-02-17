package com.example.cloud;

import com.example.cloud.conf.SingletonBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
/**
 * Главный класс для запуска API Gateway.
 */
@SpringBootApplication
public class CloudApplication {

    private final SingletonBean singletonBean;

    public CloudApplication() {
        this.singletonBean = SingletonBean.getInstance();
    }

    public static void main(String[] args) {
        SpringApplication.run(CloudApplication.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("Microservice1", r -> r.path("/serviceA/")
                        .uri("http://localhost:8081/"))
                .route("Microservice2", r -> r.path("/serviceB/")
                        .uri("http://localhost:8082/")).build();
    }
}

