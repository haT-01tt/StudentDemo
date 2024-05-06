package com.tuanha.spring.project.studentprojectspringdemo.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResBody<T> {
    private T body;
    private String code;
    private String message;

    public ResBody(T body, String code, String message) {
        this.body = body;
        this.code = code;
        this.message = message;
    }

    public ResBody(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
