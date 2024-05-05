package com.tuanha.spring.project.studentprojectspringdemo.Entity;

import com.tuanha.spring.project.studentprojectspringdemo.Entity.AbtractEntity.AbstractClass;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
