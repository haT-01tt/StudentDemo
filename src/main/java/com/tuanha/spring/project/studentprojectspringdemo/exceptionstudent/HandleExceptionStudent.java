package com.tuanha.spring.project.studentprojectspringdemo.exceptionstudent;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class HandleExceptionStudent {
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ErrorResponse handleMethodArgumentNotValid(Exception e, WebRequest request) {
        return ErrorResponse.builder()
                .code(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                .description(HttpStatus.BAD_REQUEST.getReasonPhrase().toUpperCase())
                .message(getMessage(e))
                .timestamp(new Date())
                .build();
    }

    /**
     * Lấy ra message từ exception response
     * Sẽ bắt đầu tu dau [  và kết thúc truoc dau ]
     * @param e
     * @return
     */
    private String getMessage(Exception e) {
        return e.getMessage().substring(e.getMessage().lastIndexOf("[") + 1, e.getMessage().lastIndexOf("]") - 1);
    }
}
