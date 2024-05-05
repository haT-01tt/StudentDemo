package com.tuanha.spring.project.studentprojectspringdemo.Service;

import com.tuanha.spring.project.studentprojectspringdemo.Dto.StudentDTO;
import com.tuanha.spring.project.studentprojectspringdemo.Entity.Student;
import com.tuanha.spring.project.studentprojectspringdemo.Mapper.StudentMapper;
import com.tuanha.spring.project.studentprojectspringdemo.Repo.GenericService;
import com.tuanha.spring.project.studentprojectspringdemo.Repo.MappingEntityToDTO;
import com.tuanha.spring.project.studentprojectspringdemo.StudentException;
import com.tuanha.spring.project.studentprojectspringdemo.Utils.DateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    @Autowired
    private final GenericService<Student> service;

    private final StudentMapper mapper;

    public Student saveStudent(StudentDTO studentDTO) {
        return service.save(mapper.dtoEntity().apply(studentDTO));
    }

    public List<StudentDTO> getAllStudent() {
        return mapper.listEntityToDTO().apply(service.findAll(Student.class));
    }

    public StudentDTO getByIdStudent(Integer id) {
        return mapper.entityToDTO().apply(service.findById(Student.class, id));
    }

}
