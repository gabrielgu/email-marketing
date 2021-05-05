package com.apisendmessage.service;

import com.apisendmessage.entity.SmtpConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SmtpConfigService {
    
    @Autowired
    private RestTemplate restTemplate;

    public SmtpConfig findById(){
        SmtpConfig group = this.restTemplate.getForObject("http://localhost:8085/api-email-marketing/smtp-config/1", SmtpConfig.class);
        return group;
    }
}
