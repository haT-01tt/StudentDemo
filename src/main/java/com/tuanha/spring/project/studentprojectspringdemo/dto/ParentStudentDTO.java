package com.tuanha.spring.project.studentprojectspringdemo.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ParentStudentDTO {
    List<StudentDTO> studentDTO;
    ParentDTO parentDTO;
}