package com.tuanha.spring.project.studentprojectspringdemo.repo;

import com.tuanha.spring.project.studentprojectspringdemo.entity.BonusStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BonusStudentRepository extends JpaRepository<BonusStudent, Integer> {
}
