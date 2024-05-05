package com.tuanha.spring.project.studentprojectspringdemo.Entity;

import com.tuanha.spring.project.studentprojectspringdemo.Entity.AbtractEntity.AbstractClass;
import com.tuanha.spring.project.studentprojectspringdemo.Enum.EnumStudent;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "classify_students")
public class ClassifyStudents extends AbstractClass {
    @Column(name = "conduct_grade")
    private EnumStudent conductGrade;
}
