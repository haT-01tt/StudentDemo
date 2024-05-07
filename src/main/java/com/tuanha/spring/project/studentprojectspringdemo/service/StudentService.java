package com.tuanha.spring.project.studentprojectspringdemo.service;

import com.tuanha.spring.project.studentprojectspringdemo.custom.LogSaveOperation;
import com.tuanha.spring.project.studentprojectspringdemo.custom.LogServicePerformance;
import com.tuanha.spring.project.studentprojectspringdemo.dto.StudentDto;
import com.tuanha.spring.project.studentprojectspringdemo.entity.Student;
import com.tuanha.spring.project.studentprojectspringdemo.enumstudent.ExceptionCode;
import com.tuanha.spring.project.studentprojectspringdemo.exceptionstudent.NotFoundException;
import com.tuanha.spring.project.studentprojectspringdemo.exceptionstudent.StudentException;
import com.tuanha.spring.project.studentprojectspringdemo.mapper.StudentMapper;
import com.tuanha.spring.project.studentprojectspringdemo.repo.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {

    private final StudentMapper mapper;
    private final StudentRepository repo;

    @LogSaveOperation("Save student")
    public Student saveStudent(StudentDto studentDTO) throws StudentException {
        if(ObjectUtils.isEmpty(studentDTO)){
            throw new StudentException(ExceptionCode.StudentMessage.STU_010.getCode(), ExceptionCode.StudentMessage.STU_010.getMessage());
        }
        return repo.save(mapper.dtoEntity().apply(studentDTO));
    }
    @LogSaveOperation("Save list student")
    public List<Student> saveStudents(List<StudentDto> studentDTOS) {
        return repo.saveAll(mapper.listDTOToEntity().apply(studentDTOS));
    }
    @LogServicePerformance("Find All Student")
    public Page<StudentDto> getAllStudent(Pageable pageable) {
        return convertPage(repo.findAll(pageable));
    }
    @LogServicePerformance("Get by id student")
    public StudentDto getByIdStudent(Integer id) {
        Student student = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Student not found with ID: " + id));
        return mapper.entityToDTO().apply(student);
    }

    public List<StudentDto> getAllById(List<Integer> ids) {
        return mapper.listEntityToDTO().apply(repo.findAllById(ids));
    }
    private Page<StudentDto> convertPage(Page<Student> page){
        return new PageImpl<>(page.stream().map(student -> {
            StudentDto studentDto = new StudentDto();
            BeanUtils.copyProperties(student, studentDto);
            return studentDto;
        }).toList());
    }
}
