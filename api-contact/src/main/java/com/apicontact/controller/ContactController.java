package com.apicontact.controller;

import java.util.List;

import com.apicontact.dto.ContactSaveDTO;
import com.apicontact.dto.ContactUpdateDTO;
import com.apicontact.dto.ContactViewDTO;
import com.apicontact.entity.Contact;
import com.apicontact.service.ContactService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {
    
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ContactService service;

    @PostMapping(path = "/contacts")
    public ContactViewDTO save(@RequestBody ContactSaveDTO contactDTO){
        Contact contact = modelMapper.map(contactDTO, Contact.class);
        return modelMapper.map(this.service.save(contact), ContactViewDTO.class);
    }

    @PutMapping(path = "/contacts/{id}")
    public ContactViewDTO update(@PathVariable Integer id, @RequestBody ContactUpdateDTO contactDTO){
        Contact contact = modelMapper.map(contactDTO, Contact.class);
        return modelMapper.map(this.service.update(contact, id), ContactViewDTO.class);
    }
    
    @DeleteMapping(path = "/contacts/{id}")
    public void delete(@PathVariable Integer id){
        this.service.delete(id);
    }

    @GetMapping(path = "/contacts/{id}")
    public ContactViewDTO findById(@PathVariable Integer id){
        return modelMapper.map(this.service.findById(id), ContactViewDTO.class);
    }

    @GetMapping(path = "/users/{idUser}/contacts")
    public List<ContactViewDTO> findAllByIdUser(@PathVariable Integer idUser){
        return modelMapper.map(this.service.findAllByIdUser(idUser), new TypeToken<List<ContactViewDTO>>() {}.getType());
    }

    @GetMapping(path = "/users/{idUser}/groups/{idGroup}/contacts")
    public List<ContactViewDTO> findAllByIdUserAndIdGroup(@PathVariable Integer idUser, @PathVariable Integer idGroup){
        return modelMapper.map(this.service.findAllByIdUserAndIdGroup(idUser, idGroup), new TypeToken<List<ContactViewDTO>>() {}.getType());
    }

}
