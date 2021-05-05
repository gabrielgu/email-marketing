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

@Service
public class SendMessageService {
    
    @Autowired
    private GroupService groupService;

    @Autowired
    private ContactService contactService;

    @Autowired
    private SmtpConfigService smtpConfigService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private MessageSendedRepository repository;

    public void send(){
        Group group = this.groupService.findById(1);
        List<Contact> contacts = this.contactService.findAllByIdUserAndIdGroup();
        SmtpConfig smtpConfig = this.smtpConfigService.findById();
        Message message = this.messageService.findById();

        MessageSended messageSended = new MessageSended();
        messageSended.setGroup(group);
        messageSended.setContacts(contacts);
        messageSended.setMessage(message);
        messageSended.setSmtpConfig(smtpConfig);

        this.repository.save(messageSended);
        var obj = this.repository.findAll();
        
        System.out.println(group);
    }

}
