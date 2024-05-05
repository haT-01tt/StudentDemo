package com.tuanha.spring.project.studentprojectspringdemo.Dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class GeneralDTO {
    private Integer id;
    private String name;
    private String address;
    private String phoneNumber;
    private String createAt;
    private String updateAt;
}
