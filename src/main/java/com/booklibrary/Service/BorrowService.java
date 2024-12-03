package com.booklibrary.Service;

import com.booklibrary.Repository.BookRepository;
import com.booklibrary.Repository.BorrowRepository;
import com.booklibrary.Repository.UsersRepository;
import com.booklibrary.entity.Borrow;
import com.booklibrary.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowService {
    @Autowired
    private BorrowRepository borrowRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UsersRepository usersRepository;
    public void borrowBook(Borrow borrow){
        User user = new User();
       // If(user.)
        borrowRepository.save(borrow);
    }
}
