package com.tuanha.spring.project.studentprojectspringdemo.Service;

import com.tuanha.spring.project.studentprojectspringdemo.Dto.StudentDTO;
import com.tuanha.spring.project.studentprojectspringdemo.Entity.Student;
import com.tuanha.spring.project.studentprojectspringdemo.Mapper.StudentMapper;
import com.tuanha.spring.project.studentprojectspringdemo.Repo.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final ParentService parentService;
    private final StudentMapper mapper;
    private final StudentRepository repo;

    public Student saveStudent(StudentDTO studentDTO) {
        return repo.save(mapper.dtoEntity().apply(studentDTO));
    }
    public List<Student> saveStudents(List<StudentDTO> studentDTOS) {
        return repo.saveAll(mapper.listDTOToEntity().apply(studentDTOS));
    }

    public List<StudentDTO> getAllStudent() {
        return mapper.listEntityToDTO().apply(repo.findAll());
    }

    public StudentDTO getByIdStudent(Integer id) {
        return mapper.entityToDTO().apply(repo.findById(id).orElse(null));
    }
    public List<StudentDTO> getAllById(List<Integer> ids) {
        return mapper.listEntityToDTO().apply(repo.findAllById(ids));
    }
}
