package com.apismtpconfig.repository;

import java.util.List;
import java.util.Optional;

import com.apismtpconfig.model.SmtpConfig;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SmtpConfigRepository extends JpaRepository<SmtpConfig, Integer> {
    
    List<SmtpConfig> findAllByIdUser(Integer idUser);
    
    Optional<SmtpConfig> findByHostAndUsernameAndPassword(String host, String username, String password);
}
