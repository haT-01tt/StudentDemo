package com.tuanha.spring.project.studentprojectspringdemo.dto;

import com.tuanha.spring.project.studentprojectspringdemo.enumstudent.EnumModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * A DTO for the {@link com.tuanha.spring.project.studentprojectspringdemo.entity.BonusStudent} entity
 */
@Getter
@Setter
public class BonusStudentModelDto extends GeneralDto implements Serializable {
    private String receivedDate;
    private EnumModel activeBonus;
}