package com.tuanha.spring.project.studentprojectspringdemo.entity;

import com.tuanha.spring.project.studentprojectspringdemo.entity.abtractentity.AbstractClass;
import com.tuanha.spring.project.studentprojectspringdemo.enumstudent.EnumStudent;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * Class is classify student
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "classify_students")
public class ClassifyStudents extends AbstractClass {
    @Column(name = "conduct_grade")
    @Enumerated(EnumType.STRING)
    private EnumStudent conductGrade; // This is attribute conduct grade of student
}
