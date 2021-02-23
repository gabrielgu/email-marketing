package com.apicontact.repository;

import java.util.List;
import java.util.Optional;

import com.apicontact.entity.Contact;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

    List<Contact> findAllByIdUser(Integer idUser);

    List<Contact> findAllByIdUserAndIdGroup(Integer idUser, Integer idGroup);

    Optional<Contact> findByEmailAndIdUser(String email, Integer idUser);
}
