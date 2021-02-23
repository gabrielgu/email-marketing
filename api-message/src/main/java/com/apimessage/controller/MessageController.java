package com.apimessage.controller;

import javax.validation.Valid;

import com.apimessage.dto.MessageSaveDTO;
import com.apimessage.dto.MessageViewDTO;
import com.apimessage.entity.Message;
import com.apimessage.service.MessageService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
}
