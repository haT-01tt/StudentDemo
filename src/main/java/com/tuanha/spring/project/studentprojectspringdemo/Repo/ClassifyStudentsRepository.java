package com.tuanha.spring.project.studentprojectspringdemo.Repo;

import com.tuanha.spring.project.studentprojectspringdemo.Entity.ClassifyStudents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassifyStudentsRepository extends JpaRepository<ClassifyStudents, Integer>{
}
