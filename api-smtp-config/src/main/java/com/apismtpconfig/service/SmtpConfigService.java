package com.apismtpconfig.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.apismtpconfig.exception.BusinessException;
import com.apismtpconfig.model.SmtpConfig;
import com.apismtpconfig.repository.SmtpConfigRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmtpConfigService {
    
    @Autowired
    private SmtpConfigRepository repository;

    @Transactional
    public SmtpConfig save(SmtpConfig smtpConfig){
        this.verifySmtpConfigDuplicated(smtpConfig);
        return this.repository.save(smtpConfig);
    }

    @Transactional
    public SmtpConfig update(Integer id, SmtpConfig smtpConfig){
        SmtpConfig persistedSmtpConfig = this.findById(id);

        smtpConfig.setIdUser(persistedSmtpConfig.getIdUser());
        this.verifySmtpConfigDuplicated(smtpConfig);

        persistedSmtpConfig.setHost(smtpConfig.getHost());
        persistedSmtpConfig.setUsername(smtpConfig.getUsername());
        persistedSmtpConfig.setPassword(smtpConfig.getPassword());
        return this.repository.save(persistedSmtpConfig);
    }

    @Transactional
    public void delete(Integer id){
        SmtpConfig persistedSmtpConfig = this.findById(id);
        this.repository.delete(persistedSmtpConfig);
    }
    
    public SmtpConfig findById(Integer id){
        Optional<SmtpConfig> persistedSmtpConfig = this.repository.findById(id);
        if(!persistedSmtpConfig.isPresent()){
            throw new BusinessException("Smtp Config not found.");
        }
        return persistedSmtpConfig.get();
    }

    public List<SmtpConfig> findAllByIdUser(Integer idUser){
        return this.repository.findAllByIdUser(idUser);
    }

    private void verifySmtpConfigDuplicated(SmtpConfig smtpConfig){
        Optional<SmtpConfig> persistedSmtpConfig = this.repository.findByHostAndUsernameAndPassword(
            smtpConfig.getHost(),
            smtpConfig.getUsername(),
            smtpConfig.getPassword()
        );
        if(persistedSmtpConfig.isPresent()){
            throw new BusinessException("Smtp Config duplicated.");
        }
    }

}
