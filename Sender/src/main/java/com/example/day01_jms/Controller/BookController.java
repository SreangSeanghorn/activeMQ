package com.example.day01_jms.Controller;

import com.example.day01_jms.DataEntities.Book;
import com.example.day01_jms.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@EnableJms
public class BookController {
    @Autowired
    private  BookService bookService;

    @GetMapping("/getById/{id}")
    public ResponseEntity<Book> getBook(@PathVariable long id){
        return ResponseEntity.ok(bookService.getBook(id))  ;
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }
    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        return ResponseEntity.ok(bookService.addBook(book));
    }
    @PutMapping("/update")
    public ResponseEntity<Book> updateBook(@RequestParam long id,@RequestBody Book book){
        return ResponseEntity.ok(bookService.updateBook(id,book));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable long id){
        return ResponseEntity.ok(bookService.deleteBook(id));
    }
}
