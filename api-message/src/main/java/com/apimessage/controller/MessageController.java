package com.apimessage.controller;

import java.util.List;

import javax.validation.Valid;

import com.apimessage.dto.MessageSaveDTO;
import com.apimessage.dto.MessageUpdateDTO;
import com.apimessage.dto.MessageViewDTO;
import com.apimessage.entity.Message;
import com.apimessage.service.MessageService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    
    @Autowired
    private MessageService service;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping(path = "/messages")
    public MessageViewDTO save(@Valid @RequestBody MessageSaveDTO messageDTO){
        Message message = this.modelMapper.map(messageDTO, Message.class);
        return this.modelMapper.map(this.service.save(message), MessageViewDTO.class);
    }

    @PutMapping(path = "/messages/{id}")
    public MessageViewDTO update(@PathVariable Integer id, @Valid @RequestBody MessageUpdateDTO messageDTO){
        Message message = this.modelMapper.map(messageDTO, Message.class);
        return this.modelMapper.map(this.service.update(id, message), MessageViewDTO.class);
    }

    @GetMapping(path = "/messages/{id}")
    public MessageViewDTO findById(@PathVariable Integer id){
        return this.modelMapper.map(this.service.findById(id), MessageViewDTO.class);
    }

    @GetMapping(path = "/users/{idUser}/messages")
    public List<MessageViewDTO> findByIdUser(@PathVariable Integer idUser){
        return this.modelMapper.map(this.service.findAllByIdUser(idUser), new TypeToken<List<MessageViewDTO>>() {}.getType());
    }

    @DeleteMapping(path = "/messages/{id}")
    public void delete(@PathVariable Integer id){
        this.service.delete(id);
    }

}
