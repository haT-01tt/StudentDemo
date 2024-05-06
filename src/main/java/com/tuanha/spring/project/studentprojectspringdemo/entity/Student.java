package com.tuanha.spring.project.studentprojectspringdemo.entity;

import com.tuanha.spring.project.studentprojectspringdemo.entity.abtractentity.AbstractClassEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
public class Student extends AbstractClassEntity {

    @Column(name = "student_code", unique = true)
    private String studentCode;

    @Column(name = "year_study")
    private Date yearStudy;

}
