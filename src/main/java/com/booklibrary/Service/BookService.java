package com.booklibrary.Service;

import com.booklibrary.Repository.BookRepository;
import com.booklibrary.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
    public Book findById(Long id){
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
    }
    public Book findByTitle(String title){
        return bookRepository.findByTitle(title);
    }
    public Book findByIsbn(String isbn){
        return bookRepository.findByIsbn(isbn);
    }
    public Book updateBook(Long id ,Book book){
        Optional<Book> existingBook = bookRepository.findById(id);
        if(existingBook.isEmpty()){
            System.out.println("book not exist with if = "+ id);
            //throw new RuntimeException("Book not found with ID: " + id);
        }
        Book backToUpdate = existingBook.get();
        //backToUpdate.setId(book.getId());
        backToUpdate.setIsbn(book.getIsbn());
        backToUpdate.setAuthor(book.getAuthor());
        backToUpdate.setTitle(book.getTitle());
        backToUpdate.setAvailableCopies(book.getAvailableCopies());
        return bookRepository.save(backToUpdate);
    }
    public void deleteById(Long id){
        bookRepository.deleteById(id);
    }
}
