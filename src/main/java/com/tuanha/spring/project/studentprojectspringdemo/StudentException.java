package com.tuanha.spring.project.studentprojectspringdemo;

public class StudentException extends Exception {
    private String message;
    private String code;

    public StudentException(String message, String code) {
        this.message = message;
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }
}
