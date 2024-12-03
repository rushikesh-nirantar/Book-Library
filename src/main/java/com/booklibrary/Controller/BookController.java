package com.booklibrary.Controller;

import com.booklibrary.Service.BookService;
import com.booklibrary.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @PostMapping
    public String addBook(@RequestBody Book book){
        Book saveBook = bookService.addBook(book);
        return ("Book Saved");
    }
    @GetMapping("/getAllBooks")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id){
        Book book = bookService.findById(id);
        return ResponseEntity.ok(book); //.orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
    }
    @GetMapping("/getByTitle/{title}")
    public ResponseEntity<Book> getBookByTitle(@PathVariable String title){
        Book book = bookService.findByTitle(title);
        return ResponseEntity.ok(book);
    }
    @GetMapping("/getIsbn/{isbn}")
    public ResponseEntity<Book> getBookByIsbn(@PathVariable String isbn){
        Book book = bookService.findByIsbn(isbn);
        return ResponseEntity.ok(book);
    }
    @PutMapping("/updateBook/{id}")
    public String updateBook(@RequestBody Book book ,@PathVariable Long id){
        Book updateBook = bookService.updateBook(id, book);
        return ("Book Updated");
    }
    @DeleteMapping("/deleteBook/{id}")
    public String deleteById(@PathVariable Long id){
        bookService.deleteById(id);
        return ("Book Deleted");
    }
    @PostMapping("/getBookCountByTitle/{title}")
    public int getBookCountByTitle(@PathVariable String title){
        int count = bookService.availableBooksCountByTitle(title);
        return (count);
    }
    @GetMapping("/isBookAvaliable/{id}")
    public boolean isBookAvaliable(@PathVariable Long id){
       boolean book = bookService.isBookAvaliable(id);
        return book;
    }
}
