package com.example.day01_jms_receiver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookListener {
    List<Book> books = new ArrayList<>();
    @JmsListener(destination = "testQueue")
    public void receiveMessage(final String bookAsString) {
        ObjectMapper objectMapper = new ObjectMapper();
        Book book ;
        try {
            System.out.println("Book as string: " + bookAsString);
            book = objectMapper.readValue(bookAsString,Book.class);
        } catch (JsonProcessingException e) {
            System.out.println("Error in converting JSON to Book");
            throw new RuntimeException(e);
        }
        books.add(book);
        System.out.println("JMS receiver received message:" + bookAsString);

    }
}
