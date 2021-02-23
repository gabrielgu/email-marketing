package com.apiuser.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserDTO {
    
    @NotNull(message = "Username can't be null.")
    @NotBlank(message = "Username can't be blank.")
    private String username;

    @NotNull(message = "Email can't be null.")
    @NotBlank(message = "Email can't be blank.")
    private String email;

    @NotNull(message = "Password can't be null.")
    @NotBlank(message = "Password can't be blank.")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
