package com.apimessage.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.apimessage.entity.Message;
import com.apimessage.exception.BusinessException;
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

    @Transactional
    public Message update(Integer id, Message message){
        Message persistedMessage = this.findById(id);

        persistedMessage.setTitle(message.getTitle());
        persistedMessage.setMessage(message.getMessage());

        return this.repository.save(persistedMessage);
    }

    public Message findById(Integer id){
        Optional<Message> persistedMessage = this.repository.findById(id);
        if(!persistedMessage.isPresent()){
            throw new BusinessException("Message not found.");
        }
        return persistedMessage.get();
    }

    public List<Message> findAllByIdUser(Integer idUser){
        return this.repository.findAllByIdUser(idUser);
    }

    @Transactional
    public void delete(Integer id){
        Message message = this.findById(id);
        this.repository.deleteById(message.getId());
    }
}
