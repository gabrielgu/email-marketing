package com.apisendmessage.service;

import java.util.List;

import com.apisendmessage.entity.Contact;
import com.apisendmessage.entity.Group;
import com.apisendmessage.entity.Message;
import com.apisendmessage.entity.MessageSended;
import com.apisendmessage.entity.SmtpConfig;
import com.apisendmessage.repository.MessageSendedRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MessageService {
    
    @Autowired
    private RestTemplate restTemplate;

    public Message findById(){
        Message message = this.restTemplate.getForObject("http://localhost:8084/api-email-marketing/messages/1", Message.class);
        return message;
    }

}
