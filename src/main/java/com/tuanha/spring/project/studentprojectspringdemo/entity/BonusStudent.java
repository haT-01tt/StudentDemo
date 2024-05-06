package com.tuanha.spring.project.studentprojectspringdemo.entity;

import com.tuanha.spring.project.studentprojectspringdemo.entity.abtractentity.AbstractClassDate;
import com.tuanha.spring.project.studentprojectspringdemo.enumstudent.EnumModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * The class is about rewarding students.
 * Include : id, name (Name rewarding)
 */
@Getter
@Setter
@Entity
@Table(name = "bonus_student")
public class BonusStudent extends AbstractClassDate {
    @Column(name = "received_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date receivedDate;

    @Column(name = "active_bonus")
    @Enumerated(EnumType.STRING)
    private EnumModel activeBonus;

    @Column(name = "id_student")
    private Integer idStudent;
}
