package com.apisendmessage.exception;

public class BusinessException extends RuntimeException {
    
    private static final long serialVersionUID = 2185439177500275254L;

    public BusinessException(String message) {
        super(message);
    }
}
