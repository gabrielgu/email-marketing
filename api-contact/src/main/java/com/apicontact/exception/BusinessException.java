package com.apicontact.exception;

public class BusinessException extends RuntimeException {
    
    private static final long serialVersionUID = -6191861562926778890L;

    public BusinessException(String message) {
        super(message);
    }

}
