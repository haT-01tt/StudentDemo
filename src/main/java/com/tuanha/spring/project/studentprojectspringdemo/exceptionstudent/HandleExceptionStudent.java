package com.tuanha.spring.project.studentprojectspringdemo.exceptionstudent;


import com.tuanha.spring.project.studentprojectspringdemo.utils.ModelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class HandleExceptionStudent {
    @Autowired
    ModelUtils utils;
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    protected ErrorResponse handleMethodArgumentNotValid(Exception e, WebRequest request) {
            return ErrorResponse.builder()
                    .code(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                    .description(HttpStatus.BAD_REQUEST.getReasonPhrase().toUpperCase())
                    .path(utils.getPath(request))
                    .message(utils.getMessage(e))
                    .timestamp(new Date())
                    .build();
    }



}
