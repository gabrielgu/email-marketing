package com.apigroup.repository;

import java.util.List;
import java.util.Optional;

import com.apigroup.entity.GroupContact;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<GroupContact, Integer> {
    
    List<GroupContact> findAllByIdUser(Integer idUser);

    Optional<GroupContact> findByNameAndIdUser(String name, Integer idUser);
}
