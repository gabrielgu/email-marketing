package com.apismtpconfig.controller;

import java.util.List;

import com.apismtpconfig.dto.SmtpConfigDTO;
import com.apismtpconfig.dto.SmtpConfigSaveDTO;
import com.apismtpconfig.dto.SmtpConfigUpdateDTO;
import com.apismtpconfig.model.SmtpConfig;
import com.apismtpconfig.service.SmtpConfigService;

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
public class SmtpConfigController {
    
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private SmtpConfigService service;
    
    @PostMapping(path = "/smtp-config")
    public SmtpConfigDTO save(@RequestBody SmtpConfigSaveDTO dto){
        SmtpConfig smtpConfig = this.modelMapper.map(dto, SmtpConfig.class);
        return this.modelMapper.map(this.service.save(smtpConfig), SmtpConfigDTO.class);
    }

    @PutMapping(path = "/smtp-config/{id}")
    public SmtpConfigDTO update(@PathVariable Integer id, @RequestBody SmtpConfigUpdateDTO dto){
        SmtpConfig smtpConfig = this.modelMapper.map(dto, SmtpConfig.class);
        return this.modelMapper.map(this.service.update(id, smtpConfig), SmtpConfigDTO.class);
    }

    @DeleteMapping(path = "/smtp-config/{id}")
    public void delete(@PathVariable Integer id){
        this.service.delete(id);
    }

    @GetMapping(path = "/smtp-config/{id}")
    public SmtpConfigDTO findById(@PathVariable Integer id){
        return modelMapper.map(this.service.findById(id), SmtpConfigDTO.class);
    }

    @GetMapping(path = "/users/{idUser}/smtp-config")
    public List<SmtpConfigDTO> findAllByIdUser(@PathVariable Integer idUser){
        return modelMapper.map(this.service.findAllByIdUser(idUser), new TypeToken<List<SmtpConfigDTO>>() {}.getType());
    }

}
