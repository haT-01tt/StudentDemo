package com.tuanha.spring.project.studentprojectspringdemo.repo;

import com.tuanha.spring.project.studentprojectspringdemo.entity.ClassifyStudents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassifyStudentsRepository extends JpaRepository<ClassifyStudents, Integer>{
}
