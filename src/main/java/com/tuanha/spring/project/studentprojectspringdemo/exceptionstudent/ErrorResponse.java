package com.tuanha.spring.project.studentprojectspringdemo.exceptionstudent;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@Builder
public class ErrorResponse {
    private String code;
    private String message;
    private String description;
    private Date timestamp;
}
