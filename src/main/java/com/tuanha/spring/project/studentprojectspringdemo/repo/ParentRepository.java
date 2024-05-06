package com.tuanha.spring.project.studentprojectspringdemo.repo;

import com.tuanha.spring.project.studentprojectspringdemo.entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Integer> {

    Optional<Parent> findAllByIdStudent(Integer idStudent);
}
