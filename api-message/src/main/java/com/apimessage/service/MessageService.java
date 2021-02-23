package com.apimessage.service;

import javax.transaction.Transactional;

import com.apimessage.entity.Message;
import com.apimessage.repository.MessageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    
    @Autowired
    private MessageRepository repository;

    @Transactional
    public Message save(Message message){
        return this.repository.save(message);
    }
}
