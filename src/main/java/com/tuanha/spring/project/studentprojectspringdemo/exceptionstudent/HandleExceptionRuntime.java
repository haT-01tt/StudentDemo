package com.tuanha.spring.project.studentprojectspringdemo.exceptionstudent;

import com.tuanha.spring.project.studentprojectspringdemo.utils.ModelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class HandleExceptionRuntime extends RuntimeException {
    @Autowired
    ModelUtils utils;
    @ExceptionHandler(value = {NotFoundException.class})
    protected ErrorResponse handleNotFoundException(Exception e, WebRequest request) {
        return ErrorResponse.builder()
                .code(String.valueOf(HttpStatus.NOT_FOUND.value()))
                .description(HttpStatus.NOT_FOUND.getReasonPhrase().toUpperCase())
                .path(utils.getPath(request))
                .message(e.getMessage())
                .timestamp(new Date())
                .build();
    }
    @ExceptionHandler(value = {NoSuchElementException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected ErrorResponse handleNoSuchElementException(Exception e, WebRequest request) {
        return ErrorResponse.builder()
                .code(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
                .description(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase().toUpperCase())
                .path(utils.getPath(request))
                .message(e.getMessage())
                .timestamp(new Date())
                .build();
    }
    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected ErrorResponse handleException(Exception e, WebRequest request) {
        return ErrorResponse.builder()
                .code(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
                .description(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase().toUpperCase())
                .path(utils.getPath(request))
                .message(e.getMessage())
                .timestamp(new Date())
                .build();
    }
}
