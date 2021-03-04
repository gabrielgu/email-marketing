package com.apimessage.repository;

import java.util.List;

import com.apimessage.entity.Message;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    
    List<Message> findAllByIdUser(Integer idUser);
    
}
