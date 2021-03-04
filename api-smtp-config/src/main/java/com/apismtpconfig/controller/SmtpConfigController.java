package com.apismtpconfig.controller;

import com.apismtpconfig.service.SmtpConfigService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmtpConfigController {
    
    @Autowired
    private SmtpConfigService service;
    
}
