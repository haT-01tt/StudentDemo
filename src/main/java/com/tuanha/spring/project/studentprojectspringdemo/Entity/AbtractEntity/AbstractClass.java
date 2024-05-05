package com.tuanha.spring.project.studentprojectspringdemo.Entity.AbtractEntity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


/**
 * This is a general class.
 * If you want to create a new class then you need to extend the class
 */
@Getter
@Setter
@MappedSuperclass
public abstract class AbstractClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;
}
