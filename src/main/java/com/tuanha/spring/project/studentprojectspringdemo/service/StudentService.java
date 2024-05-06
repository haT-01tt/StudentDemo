package com.tuanha.spring.project.studentprojectspringdemo.service;

import com.tuanha.spring.project.studentprojectspringdemo.dto.StudentDto;
import com.tuanha.spring.project.studentprojectspringdemo.entity.Student;
import com.tuanha.spring.project.studentprojectspringdemo.mapper.StudentMapper;
import com.tuanha.spring.project.studentprojectspringdemo.repo.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final ParentService parentService;
    private final StudentMapper mapper;
    private final StudentRepository repo;

    public Student saveStudent(StudentDto studentDTO) {
        return repo.save(mapper.dtoEntity().apply(studentDTO));
    }
    public List<Student> saveStudents(List<StudentDto> studentDTOS) {
        return repo.saveAll(mapper.listDTOToEntity().apply(studentDTOS));
    }

    public List<StudentDto> getAllStudent() {
        return mapper.listEntityToDTO().apply(repo.findAll());
    }

    public StudentDto getByIdStudent(Integer id) {
        return mapper.entityToDTO().apply(repo.findById(id).orElse(null));
    }
    public List<StudentDto> getAllById(List<Integer> ids) {
        return mapper.listEntityToDTO().apply(repo.findAllById(ids));
    }
}
