package com.example.day01_jms_book_rest_client;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
    private String title;
    private String author;
    private String genre;

    public Book(String title, String author, String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

}
