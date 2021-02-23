package com.apigroup.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.apigroup.entity.GroupContact;
import com.apigroup.exception.BusinessException;
import com.apigroup.repository.GroupRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupService {
    
    @Autowired
    private GroupRepository repository;

    @Transactional
    public GroupContact save(GroupContact group){
        this.validateUniqueGroupContact(group);
        return this.repository.save(group);
    }

    @Transactional
    public GroupContact update(Integer id, GroupContact group){
        this.validateUniqueGroupContact(group);
        GroupContact persistedGroup = this.findById(id);
        persistedGroup.setName(group.getName());
        return this.repository.save(persistedGroup);
    }

    @Transactional
    public void delete(Integer id){
        GroupContact persistedGroup = this.findById(id);
        this.repository.delete(persistedGroup);
    }

    public GroupContact findById(Integer id){
        Optional<GroupContact> group = this.repository.findById(id);
        if(group.isEmpty()){
            throw new BusinessException("Group not found.");
        }
        return group.get();
    }

    public List<GroupContact> findAllByIdUser(Integer idUser){
        return this.repository.findAllByIdUser(idUser);
    }

    public void validateUniqueGroupContact(GroupContact group){
        Optional<GroupContact> persistedGroup = this.repository.findByNameAndIdUser(group.getName(), group.getIdUser());
        if(persistedGroup.isPresent()){
            throw new BusinessException("Group already exists.");
        }
    }
}
