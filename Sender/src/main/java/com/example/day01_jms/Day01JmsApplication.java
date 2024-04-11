package com.example.day01_jms;

import com.example.day01_jms.Service.Implementation.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.client.RestTemplate;

@SpringBootApplication

public class Day01JmsApplication implements CommandLineRunner {
    RestTemplate restTemplate = new RestTemplate();
    @Autowired
    ProducerService produderService ;
    public static void main(String[] args) {
        SpringApplication.run(Day01JmsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
      //  String serverUrl = "http://localhost:8080/book";
     //   restTemplate.postForLocation(serverUrl, new Book("The Alchemist", "Paulo Coelho", "1988"));
    }
}
