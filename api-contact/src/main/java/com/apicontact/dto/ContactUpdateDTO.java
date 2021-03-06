package com.apicontact.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ContactUpdateDTO {
    
    @NotNull(message = "Name can't be null.")
    @NotBlank(message = "Name can't be blank.")
    private String name;

    @NotNull(message = "Email can't be null.")
    @NotBlank(message = "Email can't be blank.")
    private String email;

    private Integer idGroup;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(Integer idGroup) {
        this.idGroup = idGroup;
    }

}
