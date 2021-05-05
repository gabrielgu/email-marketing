package com.apisendmessage.controller;

import com.apisendmessage.dto.MessageToSendDTO;
import com.apisendmessage.entity.MessageSended;
import com.apisendmessage.service.SendMessageService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send-message")
public class SendMessageController {
    
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private SendMessageService service;

    @PostMapping
    public void send(@RequestBody MessageToSendDTO messageToSendDTO){
        this.service.send();
    }
}
