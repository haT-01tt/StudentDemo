package com.tuanha.spring.project.studentprojectspringdemo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTO extends GeneralDTO{
    @NotBlank(message = "Student code can't empty")
    private String studentCode;
    private String yearStudy;
}
