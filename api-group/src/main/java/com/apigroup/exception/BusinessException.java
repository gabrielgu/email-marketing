package com.apigroup.exception;

public class BusinessException extends RuntimeException {
    
    private static final long serialVersionUID = -9009103459088836173L;

    public BusinessException(String message) {
        super(message);
    }

}
