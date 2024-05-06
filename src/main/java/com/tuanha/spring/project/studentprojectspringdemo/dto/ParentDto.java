package com.tuanha.spring.project.studentprojectspringdemo.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ParentDto extends GeneralModelDto {
    String job;
    @NotNull(message = "Id Student can't empty")
    Integer idStudent;
}
