package com.example.thymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SpringThymeleafTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringThymeleafTemplateApplication.class, args);
    }

}
