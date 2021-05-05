package com.apisendmessage.service;

import java.util.List;

import com.apisendmessage.entity.Contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ContactService {
    
    @Autowired
    private RestTemplate restTemplate;

    public List<Contact> findAllByIdUserAndIdGroup(){
        ResponseEntity<Contact[]> contacts = this.restTemplate.getForEntity("http://localhost:8082/api-email-marketing/users/1/groups/1/contacts", 
        Contact[].class);
        return List.of(contacts.getBody());
    }
    
}
