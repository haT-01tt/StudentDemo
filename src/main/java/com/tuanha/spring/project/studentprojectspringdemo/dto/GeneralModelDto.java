package com.tuanha.spring.project.studentprojectspringdemo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.Date;


@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeneralModelDto {
    private Integer id;
    @NotBlank(message = "Name can't be empty")
    @Length(min = 1, max = 20)
    private String name;
    private String address;
    @NotBlank(message = "Phone Number can't be empty")
    @Length(max = 10)
    private String phoneNumber;
    private String createAt;
    private String updateAt;
    private Date dateOfBirth;
}
