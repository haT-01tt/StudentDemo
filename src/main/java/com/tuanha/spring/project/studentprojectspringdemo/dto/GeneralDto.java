package com.tuanha.spring.project.studentprojectspringdemo.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class GeneralDto {
    private Integer id;
    @NotBlank(message = "Name can't empty")
    @Length(min = 1, max = 50, message = "Name must be between 1 and 50 characters")
    private String name;
    private String createAt;
    private String updateAt;

}
