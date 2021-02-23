package com.apiuser.repository;

import java.util.Optional;

import com.apiuser.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    
    Optional<User> findByUsernameAndEmail(String username, String email);
}
