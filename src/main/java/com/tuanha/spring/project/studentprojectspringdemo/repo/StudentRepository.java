package com.tuanha.spring.project.studentprojectspringdemo.repo;

import com.tuanha.spring.project.studentprojectspringdemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findAllByIdParent(Integer idParent);
}
