package com.example.day01_jms.Service.Implementation;

import com.example.day01_jms.DataEntities.Book;
import com.example.day01_jms.Repository.BookRepository;
import com.example.day01_jms.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImp implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private ProducerService producerService;
    @Override
    public Book addBook(Book book) {
        producerService.sendMessageToQueueWithObjectBook(book);
        return bookRepository.save(book);
    }

    @Override
    public Book getBook(long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book updateBook(long id,Book book) {
        Book b = bookRepository.findById(id).get();
        b.setTitle(book.getTitle());
        b.setAuthor(book.getAuthor());
        b.setGenre(book.getGenre());
        return bookRepository.save(b);
    }

    @Override
    public Book deleteBook(long id) {
        Book b = bookRepository.findById(id).get();
        producerService.sendMessageToQueueWithObjectBook(b);
        bookRepository.deleteById(id);
        return b;
    }
}
