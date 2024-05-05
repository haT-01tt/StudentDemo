package com.tuanha.spring.project.studentprojectspringdemo.Entity;

import com.tuanha.spring.project.studentprojectspringdemo.Entity.AbtractEntity.AbstractClassEntity;
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
public class ParentStudent extends AbstractClassEntity {
    @Column(name = "job_parent_student")
    private String job;
}
