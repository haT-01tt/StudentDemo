package com.tuanha.spring.project.studentprojectspringdemo.entity;

import com.tuanha.spring.project.studentprojectspringdemo.entity.abtractentity.AbstractClass;
import com.tuanha.spring.project.studentprojectspringdemo.enumstudent.EnumModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "tuition")
@NoArgsConstructor
@AllArgsConstructor
public class Tuition extends AbstractClass {

    @Column(name = "active_tuition")
    @Enumerated(EnumType.STRING)
    private EnumModel activeTuition;

    @Column(name = "description")
    private String description;

    @Column(name = "id_student")
    private String idStudent;
}
