package com.tuanha.spring.project.studentprojectspringdemo.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ParentStudentDto {
    List<StudentDto> studentDTO;
    ParentDto parentDTO;


    public ParentStudentDto() {
    }
}
