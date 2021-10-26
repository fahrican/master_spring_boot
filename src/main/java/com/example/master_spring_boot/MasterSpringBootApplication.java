package com.example.master_spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MasterSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MasterSpringBootApplication.class, args);
    }
}
