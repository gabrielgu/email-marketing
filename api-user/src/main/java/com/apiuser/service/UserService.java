package com.apiuser.service;

import java.util.Optional;

import javax.transaction.Transactional;

import com.apiuser.entity.User;
import com.apiuser.exception.BusinessException;
import com.apiuser.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;

    @Transactional
    public User save(User user){ 
        this.verifyUniqueUsernameAndPassword(user);
        return this.repository.save(user);
    }

    @Transactional
    public User update(User user, Integer id){
        this.verifyUniqueUsernameAndPassword(user);
        User persistedUser = this.findBy(id);
        persistedUser.setUsername(user.getUsername());
        persistedUser.setEmail(user.getEmail());
        persistedUser.setPassword(user.getPassword());
        return this.repository.save(persistedUser);
    }

    @Transactional
    public void delete(Integer id){
        User persistedUser = this.findBy(id);
        this.repository.delete(persistedUser);
    }

    public User findBy(Integer id){
        Optional<User> optionalUser = this.repository.findById(id);
        if(!optionalUser.isPresent()){
            throw new BusinessException("User not found.");
        }
        return optionalUser.get();
    }

    public Optional<User> findBy(String username, String email){
        return this.repository.findByUsernameAndEmail(username, email);
    }

    private void verifyUniqueUsernameAndPassword(User user){
        if(this.findBy(user.getUsername(), user.getEmail()).isPresent()){
            throw new BusinessException("Username or Email already exists.");
        }
    }
}
