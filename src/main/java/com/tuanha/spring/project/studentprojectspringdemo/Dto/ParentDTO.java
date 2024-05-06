package com.tuanha.spring.project.studentprojectspringdemo.Dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ParentDTO extends GeneralDTO{
    String job;

    Integer idStudent;
}
