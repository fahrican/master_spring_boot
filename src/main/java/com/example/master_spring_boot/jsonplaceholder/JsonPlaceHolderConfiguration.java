package com.example.master_spring_boot.jsonplaceholder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JsonPlaceHolderConfiguration {

    @Bean("jsonplaceholder")
    CommandLineRunner commandLineRunner(JsonPlaceHolderClient client) {
        return args -> {
            System.out.println("https://jsonplaceholder.typicode.com/posts");
            System.out.println(client.getPosts().size());
            System.out.println();
            System.out.println("https://jsonplaceholder.typicode.com/posts/3");
            System.out.println(client.getPost(3));
        };
    }

}
