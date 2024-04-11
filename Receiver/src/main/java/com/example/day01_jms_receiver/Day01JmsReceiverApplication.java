package com.example.day01_jms_receiver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class Day01JmsReceiverApplication {
    public static void main(String[] args) {
        SpringApplication.run(Day01JmsReceiverApplication.class, args);
    }

}
