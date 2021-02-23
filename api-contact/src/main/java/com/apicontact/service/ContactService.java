package com.apicontact.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.apicontact.entity.Contact;
import com.apicontact.exception.BusinessException;
import com.apicontact.repository.ContactRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    
    @Autowired
    private ContactRepository repository;

    @Transactional
    public Contact save(Contact contact){
        this.verifyContactDuplicated(contact);
        return this.repository.save(contact);
    }

    @Transactional
    public Contact update(Contact contact, Integer id){
        Contact persistedContact = this.findById(id);

        contact.setIdUser(persistedContact.getIdUser());
        this.verifyContactDuplicated(contact);

        persistedContact.setName(contact.getName());
        persistedContact.setEmail(contact.getEmail());
        persistedContact.setIdGroup(contact.getIdGroup());
        return this.repository.save(persistedContact);
    }

    @Transactional
    public void delete(Integer id){
        Contact persistedContact = this.findById(id);
        this.repository.delete(persistedContact);
    }

    public Contact findById(Integer id){
        Optional<Contact> persistedContact = this.repository.findById(id);
        if(!persistedContact.isPresent()){
            throw new BusinessException("Contact not found.");
        }
        return persistedContact.get();
    }

    public List<Contact> findAllByIdUser(Integer idUser){
        return this.repository.findAllByIdUser(idUser);
    }

    public List<Contact> findAllByIdUserAndIdGroup(Integer idUser, Integer idGroup){
        return this.repository.findAllByIdUserAndIdGroup(idUser, idGroup);
    }

    private void verifyContactDuplicated(Contact contact){
        Optional<Contact> persistedContact = this.repository.findByEmailAndIdUser(contact.getEmail(), contact.getIdUser());
        if(persistedContact.isPresent()){
            throw new BusinessException("Contact duplicated.");
        }
    }
}
