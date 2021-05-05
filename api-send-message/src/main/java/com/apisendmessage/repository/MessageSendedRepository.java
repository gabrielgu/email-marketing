package com.apisendmessage.repository;

import com.apisendmessage.entity.MessageSended;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageSendedRepository extends MongoRepository<MessageSended, String> {
    
}
