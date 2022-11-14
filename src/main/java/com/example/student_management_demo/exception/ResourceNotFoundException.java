package com.example.student_management_demo.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException{
    private String debugMessage;
    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, String debugMessage) {
        super(message);
        this.debugMessage = debugMessage;
    }
}
