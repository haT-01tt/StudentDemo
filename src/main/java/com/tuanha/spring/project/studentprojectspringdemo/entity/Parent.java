package com.tuanha.spring.project.studentprojectspringdemo.entity;

import com.tuanha.spring.project.studentprojectspringdemo.entity.abtractentity.AbstractClassEntity;
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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "parent_student")
public class Parent extends AbstractClassEntity {
    @Column(name = "job_parent_student")
    String job;

    @Column(name = "id_student")
    Long idStudent;

    @Column(name = "id_study")
    Long idStudy;
}
