package com.tuanha.spring.project.studentprojectspringdemo.Entity;

import com.tuanha.spring.project.studentprojectspringdemo.Entity.AbtractEntity.AbstractClassEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "bonus_student")
public class BonusStudent extends AbstractClassEntity {
}
