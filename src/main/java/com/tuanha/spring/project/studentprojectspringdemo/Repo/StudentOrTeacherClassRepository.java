package com.tuanha.spring.project.studentprojectspringdemo.Repo;

import com.tuanha.spring.project.studentprojectspringdemo.Entity.StudentOrTeacherClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentOrTeacherClassRepository extends JpaRepository<StudentOrTeacherClass, Integer>{
}
