package com.example.day01_jms.Service;

import com.example.day01_jms.DataEntities.Book;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {
    Book addBook(Book book);
    Book getBook(long id);
    List<Book> getAllBooks();
    Book updateBook(long id,Book book);
    Book deleteBook(long id );
}
