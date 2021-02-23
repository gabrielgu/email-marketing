package com.apigroup.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class GroupUpdateDTO {
    
    @NotBlank(message = "Name can't be blank.")
    @NotNull(message = "Name can't be null.")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
