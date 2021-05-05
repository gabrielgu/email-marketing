package com.apisendmessage.entity;

import java.util.List;

import org.springframework.data.annotation.Id;

public class MessageSended {
 
    @Id
    private String Id;

    private Group group;
    
    private List<Contact> contacts;

    private Message message;

    private SmtpConfig smtpConfig;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
    
    public SmtpConfig getSmtpConfig() {
        return smtpConfig;
    }

    public void setSmtpConfig(SmtpConfig smtpConfig) {
        this.smtpConfig = smtpConfig;
    }

}
