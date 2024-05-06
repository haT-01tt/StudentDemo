package com.tuanha.spring.project.studentprojectspringdemo.repo;

import com.tuanha.spring.project.studentprojectspringdemo.entity.StudentOrTeacherClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentOrTeacherClassRepository extends JpaRepository<StudentOrTeacherClass, Integer>{
}
