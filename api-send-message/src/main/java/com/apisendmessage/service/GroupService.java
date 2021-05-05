package com.apisendmessage.service;

import com.apisendmessage.entity.Group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GroupService {
    
    @Autowired
    private RestTemplate restTemplate;

    public Group findById(Integer idGroup){
        Group group = this.restTemplate.getForObject("http://localhost:8083/api-email-marketing/groups/1", Group.class);
        return group;
    }
}
