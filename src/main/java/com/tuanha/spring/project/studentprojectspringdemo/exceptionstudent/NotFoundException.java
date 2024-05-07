package com.tuanha.spring.project.studentprojectspringdemo.exceptionstudent;


import java.util.function.Supplier;

public class NotFoundException extends RuntimeException {
    private String message;
    private int cause;
    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public NotFoundException(int cause, String message) {
        this.message = message;
        this.cause = cause;
    }
}
