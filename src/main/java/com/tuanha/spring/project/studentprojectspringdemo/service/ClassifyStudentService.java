package com.tuanha.spring.project.studentprojectspringdemo.service;

import com.tuanha.spring.project.studentprojectspringdemo.repo.ClassifyStudentsRepository;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class ClassifyStudentService {
    ClassifyStudentsRepository classifyStudentsRepository;
}
