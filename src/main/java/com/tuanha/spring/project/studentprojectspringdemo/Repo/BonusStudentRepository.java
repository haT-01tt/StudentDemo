package com.tuanha.spring.project.studentprojectspringdemo.Repo;

import com.tuanha.spring.project.studentprojectspringdemo.Entity.BonusStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BonusStudentRepository extends JpaRepository<BonusStudent, Integer> {
}
