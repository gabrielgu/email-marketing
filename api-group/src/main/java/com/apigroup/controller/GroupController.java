package com.apigroup.controller;

import java.util.List;

import javax.validation.Valid;

import com.apigroup.dto.GroupSaveDTO;
import com.apigroup.dto.GroupUpdateDTO;
import com.apigroup.dto.GroupViewDTO;
import com.apigroup.entity.GroupContact;
import com.apigroup.service.GroupService;

import org.modelmapper.TypeToken;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroupController {
    
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private GroupService service;

    @PostMapping(path = "/groups")
    public GroupViewDTO save(@RequestBody @Valid GroupSaveDTO groupDTO){
        GroupContact group = this.modelMapper.map(groupDTO, GroupContact.class);
        return this.modelMapper.map(this.service.save(group), GroupViewDTO.class);
    }

    @PutMapping(path = "/groups/{id}")
    public GroupViewDTO update(@PathVariable Integer id, @RequestBody @Valid GroupUpdateDTO groupDTO){
        GroupContact group = this.modelMapper.map(groupDTO, GroupContact.class);
        return this.modelMapper.map(this.service.update(id, group), GroupViewDTO.class);
    }

    @DeleteMapping(path = "/groups/{id}")
    public void delete(@PathVariable Integer id){
        this.service.delete(id);
    }

    @GetMapping(path = "/groups/{id}")
    public GroupViewDTO findById(@PathVariable Integer id){
        return this.modelMapper.map(this.service.findById(id), GroupViewDTO.class);
    }

    @GetMapping(path = "/users/{idUser}/groups")
    public List<GroupViewDTO> findByIdUser(@PathVariable Integer idUser){
        return this.modelMapper.map(this.service.findAllByIdUser(idUser), new TypeToken<List<GroupViewDTO>>() {}.getType());
    }

}
