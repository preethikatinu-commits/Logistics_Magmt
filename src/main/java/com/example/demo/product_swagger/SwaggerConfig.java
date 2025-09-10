package com.example.demo.product_swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI apiDoc() {
        return new OpenAPI()
                .info(new Info()
                        .title("Logistics Management System - Product API")
                        .version("1.0")
                        .description("CRUD operations for product management"));
    }
}