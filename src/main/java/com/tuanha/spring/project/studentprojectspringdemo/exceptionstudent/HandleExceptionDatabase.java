package com.tuanha.spring.project.studentprojectspringdemo.exceptionstudent;

import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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


    private String extractFieldNameFromException(InvalidDataAccessResourceUsageException ex) {
        Matcher matcher = Pattern.compile("Unknown column '(\\w+)' in 'field list'").matcher(ex.getMessage());
        return matcher.find() ? matcher.group(1) : "";
    }

    private String getMessage(Exception e) {
        return e.getMessage().substring(e.getMessage().lastIndexOf("[") + 1, e.getMessage().lastIndexOf("]") - 1);
    }
}
