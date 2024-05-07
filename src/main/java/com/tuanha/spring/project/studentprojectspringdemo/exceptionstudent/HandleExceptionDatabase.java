package com.tuanha.spring.project.studentprojectspringdemo.exceptionstudent;

import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class HandleExceptionDatabase {

    @ExceptionHandler(InvalidDataAccessResourceUsageException.class)
    public ResponseEntity<ErrorResponse> handleDatabaseException(InvalidDataAccessResourceUsageException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponse.builder()
                        .code(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                        .message(ex.getMessage())
                        .description(HttpStatus.BAD_GATEWAY.getReasonPhrase().toUpperCase())
                        .timestamp(new Date())
                        .build());
    }
}
