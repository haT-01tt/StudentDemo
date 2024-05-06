package com.tuanha.spring.project.studentprojectspringdemo.entity;

import com.tuanha.spring.project.studentprojectspringdemo.entity.abtractentity.AbstractClass;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "subject")
public class Subject extends AbstractClass {

    @Column(name = "subject_code", unique = true)
    String subjectCode;

    @Column(name = "semester")
    Integer semester;
}
