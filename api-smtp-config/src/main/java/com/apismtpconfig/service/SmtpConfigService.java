package com.apismtpconfig.service;

import com.apismtpconfig.repository.SmtpConfigRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmtpConfigService {
    
    @Autowired
    private SmtpConfigRepository repository;

    
}
