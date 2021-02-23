package com.apimessage.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

public class MessageSaveDTO {
    
    @NotNull(message = "Title can't be null.")
    @NotBlank(message = "Title can't be blank.")
    private String title;

    @NotNull(message = "Message can't be null.")
    @NotBlank(message = "Message can't be blank.")
    private String message;

    @Null
    @NotEmpty
    @NotBlank
    @NotNull(message = "ID user can't be null.")
    private Integer idUser;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

}
