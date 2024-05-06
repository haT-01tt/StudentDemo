package com.tuanha.spring.project.studentprojectspringdemo.entity;

import com.tuanha.spring.project.studentprojectspringdemo.entity.abtractentity.AbstractClass;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Class is used to keep track of the class in which a student or teacher is studying or teaching.
 */
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student_or_teacher_class")
public class StudentOrTeacherClass extends AbstractClass {
    @Column(name = "grade")
    private String grade;
}
