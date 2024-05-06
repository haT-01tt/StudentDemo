package com.tuanha.spring.project.studentprojectspringdemo.mapper;

import com.tuanha.spring.project.studentprojectspringdemo.dto.StudentDto;
import com.tuanha.spring.project.studentprojectspringdemo.entity.Student;
import com.tuanha.spring.project.studentprojectspringdemo.repo.MappingEntityToDTO;
import com.tuanha.spring.project.studentprojectspringdemo.exceptionstudent.StudentException;
import com.tuanha.spring.project.studentprojectspringdemo.utils.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class StudentMapper implements
        MappingEntityToDTO<StudentDto, Student> {
    @Override
    public Function<StudentDto, Student> dtoEntity() {
        return dto -> {
            Student student = new Student();
            try {
                if(dto.getYearStudy() != null){
                    student.setYearStudy(DateUtils.convertStringToDate(dto.getYearStudy()));
                }
                if(dto.getCreateAt() != null){
                    student.setCreateAt(DateUtils.convertStringToDate(dto.getCreateAt()));
                }
                if(dto.getUpdateAt() != null){
                    student.setUpdateAt(DateUtils.convertStringToDate(dto.getUpdateAt()));
                }
            } catch (StudentException e) {
                throw new RuntimeException(e.getMessage());
            }
            BeanUtils.copyProperties(dto, student);
            return student;
        };
    }

    public Function<List<Student>, List<StudentDto>> listEntityToDTO() {
        return entities -> entities.stream()
                .map(student -> {
                    StudentDto studentDTO = new StudentDto();
                    mapperEntityToDto(student).accept(studentDTO);
                    return studentDTO;
                })
                .collect(Collectors.toList());
    }
    public Function<List<StudentDto>, List<Student>> listDTOToEntity() {
        return entities -> entities.stream()
                .map(student -> {
                    Student stu = new Student();
                    mapperDtoToEntity(student).accept(stu);
                    return stu;
                })
                .collect(Collectors.toList());
    }
    public Function<Student, StudentDto> entityToDTO() {
        return student -> {
            StudentDto studentDTO = new StudentDto();
            mapperEntityToDto(student).accept(studentDTO);
            return studentDTO;
        };
    }
    public Consumer<StudentDto> mapperEntityToDto(Student student){
        return studentDTO -> {
            studentDTO.setYearStudy(DateUtils.convertDateToString(student.getYearStudy()));
            studentDTO.setCreateAt(DateUtils.convertDateToString(student.getCreateAt()));
            studentDTO.setUpdateAt(DateUtils.convertDateToString(student.getUpdateAt()));
            BeanUtils.copyProperties(student, studentDTO);
        };
    }
    public Consumer<Student> mapperDtoToEntity(StudentDto studentDTO){
        return entity -> {
            try {
                if(studentDTO.getYearStudy() != null) entity.setYearStudy(DateUtils.convertStringToDate(studentDTO.getYearStudy()));
                if(studentDTO.getCreateAt() != null) entity.setCreateAt(DateUtils.convertStringToDate(studentDTO.getCreateAt()));
                if(studentDTO.getUpdateAt() != null) entity.setUpdateAt(DateUtils.convertStringToDate(studentDTO.getUpdateAt()));
            } catch (StudentException e) {
                throw new RuntimeException(e);
            }
            BeanUtils.copyProperties(entity, studentDTO);
        };
    }
}
