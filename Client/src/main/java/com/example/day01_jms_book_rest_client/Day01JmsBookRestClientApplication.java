package com.example.day01_jms_book_rest_client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class Day01JmsBookRestClientApplication implements CommandLineRunner {
    RestTemplate restTemplate = new RestTemplate();
    public static void main(String[] args) {
        SpringApplication.run(Day01JmsBookRestClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String serverUrl = "http://localhost:8080/book";
            // add a book
            restTemplate.postForLocation(serverUrl+"/add", new Book("The Alchemist", "Paulo Coelho", "1988"));

            // get a book
            Book book = restTemplate.getForObject(serverUrl + "/getById/{id}", Book.class,3);
            System.out.println("----------- get a book-----------------------");
            System.out.println(book);
            // get all books
            List<Book>  books= restTemplate.getForObject(serverUrl+"/getAll", List.class);
            System.out.println("----------- get all books-----------------------");
            System.out.println(books);

            // delete a book
            restTemplate.delete(serverUrl+"/delete/{id}", 2);

    }
}
