package com.apigroup.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class GroupSaveDTO {
    
    @NotBlank(message = "Name can't be blank.")
    @NotNull(message = "Name can't be null.")
    private String name;

    @NotNull(message = "ID User can't be null.")
    private Integer idUser;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

}
