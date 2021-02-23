package com.apiuser.controller;

import javax.validation.Valid;

import com.apiuser.dto.UserDTO;
import com.apiuser.dto.UserViewDTO;
import com.apiuser.entity.User;
import com.apiuser.service.UserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users")
public class UserController {
    
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserService service;

    @PostMapping
    public UserViewDTO save(@RequestBody @Valid UserDTO userDTO){
        User user = modelMapper.map(userDTO, User.class);
        return modelMapper.map(this.service.save(user), UserViewDTO.class);
    }

    @PutMapping(path = "/{id}")
    public UserViewDTO update(@PathVariable Integer id, @RequestBody @Valid UserDTO userDTO){
        User user = modelMapper.map(userDTO, User.class);
        return modelMapper.map(this.service.update(user, id), UserViewDTO.class);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        this.service.delete(id);
    }

    @GetMapping(path = "/{id}")
    public UserViewDTO findBy(@PathVariable Integer id){
        return modelMapper.map(this.service.findBy(id), UserViewDTO.class);
    }
}
