package com.booklibrary.Service;

import com.booklibrary.Repository.UsersRepository;
import com.booklibrary.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UsersRepository usersRepository;
    public void saveUser(User user){
        usersRepository.save(user);
    }
    public List<User> findAll(){
        return usersRepository.findAll();
    }
    public Optional<User> findById(Long id){
        return usersRepository.findById(id);
    }
    public void updateUser (Long id, User user){
        Optional<User> existingUser = usersRepository.findById(id);
        if(existingUser.isEmpty()){
            throw new RuntimeException("user not exist");
        }
       User updateExistingUser = existingUser.get();
        updateExistingUser.setName(user.getName());
        updateExistingUser.setEmail(user.getEmail());
        updateExistingUser.setBorrowedBooks(user.getBorrowedBooks());
        usersRepository.save(updateExistingUser);
    }
    public void deleteUser(Long id){
        usersRepository.deleteById(id);
    }

}
