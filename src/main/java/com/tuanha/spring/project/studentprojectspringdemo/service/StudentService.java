package com.tuanha.spring.project.studentprojectspringdemo.service;

import com.tuanha.spring.project.studentprojectspringdemo.custom.LogSaveOperation;
import com.tuanha.spring.project.studentprojectspringdemo.custom.LogServicePerformance;
import com.tuanha.spring.project.studentprojectspringdemo.dto.StudentDto;
import com.tuanha.spring.project.studentprojectspringdemo.entity.Student;
import com.tuanha.spring.project.studentprojectspringdemo.exceptionstudent.NotFoundException;
import com.tuanha.spring.project.studentprojectspringdemo.mapper.FnMapper;
import com.tuanha.spring.project.studentprojectspringdemo.repo.StudentRepository;
import com.tuanha.spring.project.studentprojectspringdemo.utils.DateUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {

    private final StudentRepository repo;

    @LogSaveOperation("Save student")
    public Student saveStudent(StudentDto studentDTO){
        return repo.saveAndFlush(FnMapper.createEntity(Student::new,
                student -> BeanUtils.copyProperties(studentDTO, student)));
    }
    @LogSaveOperation("Save list student")
    public List<Student> saveStudents(List<StudentDto> studentDTOS) {
        return repo.saveAllAndFlush(FnMapper.<StudentDto, Student>mapperList(Student::new).apply(studentDTOS));
    }
    @LogServicePerformance("Find All Student")
    public Page<StudentDto> getAllStudent(Pageable pageable) {
        return FnMapper.convertPage(repo.findAll(pageable), StudentDto::new);
    }
    @LogServicePerformance("Get by id student")
    public StudentDto getByIdStudent(Integer id) {
        Student student = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Student not found with ID: " + id));
        return FnMapper.createEntity(StudentDto::new,
                mapperEntityToDto(student)
                        .andThen(FnMapper.consumer(student)));
    }

    public List<StudentDto> getAllById(Integer id) {
       List<Student> students = repo.findAllByIdParent(id);
       if(students.isEmpty()){
           throw new NotFoundException("Student not found with ID: " + id);
       }
        return FnMapper.<Student, StudentDto>mapperList(StudentDto::new).apply(students);
    }
    public Consumer<StudentDto> mapperEntityToDto(Student student){
        return studentDTO -> {
            studentDTO.setYearStudy(DateUtils.convertDateToString(student.getYearStudy()));
            studentDTO.setCreateAt(DateUtils.convertDateToString(student.getCreateAt()));
            studentDTO.setUpdateAt(DateUtils.convertDateToString(student.getUpdateAt()));
        };
    }
}
