package com.apimessage.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class MessageUpdateDTO {
    
    @NotNull(message = "Title can't be null.")
    @NotBlank(message = "Title can't be blank.")
    private String title;

    @NotNull(message = "Message can't be null.")
    @NotBlank(message = "Message can't be blank.")
    private String message;

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

}
