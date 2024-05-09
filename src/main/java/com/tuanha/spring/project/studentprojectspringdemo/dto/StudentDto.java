package com.tuanha.spring.project.studentprojectspringdemo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDto extends GeneralModelDto {
    @NotBlank(message = "Student code can't empty")
    private String studentCode;
    private String yearStudy;
    private Integer idParent;
}
