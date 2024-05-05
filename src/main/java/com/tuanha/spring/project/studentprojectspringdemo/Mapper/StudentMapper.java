package com.tuanha.spring.project.studentprojectspringdemo.Mapper;

import com.tuanha.spring.project.studentprojectspringdemo.Dto.StudentDTO;
import com.tuanha.spring.project.studentprojectspringdemo.Entity.Student;
import com.tuanha.spring.project.studentprojectspringdemo.Repo.MappingEntityToDTO;
import com.tuanha.spring.project.studentprojectspringdemo.StudentException;
import com.tuanha.spring.project.studentprojectspringdemo.Utils.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class StudentMapper implements
        MappingEntityToDTO<StudentDTO, Student> {
    @Override
    public Function<StudentDTO, Student> dtoEntity() {
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

    public Function<List<Student>, List<StudentDTO>> listEntityToDTO() {
        return entities -> entities.stream()
                .map(student -> {
                    StudentDTO studentDTO = new StudentDTO();
                    mapperEntityToDto(student).accept(studentDTO);
                    return studentDTO;
                })
                .collect(Collectors.toList());
    }
    public Function<Student, StudentDTO> entityToDTO() {
        return student -> {
            StudentDTO studentDTO = new StudentDTO();
            mapperEntityToDto(student).accept(studentDTO);
            return studentDTO;
        };
    }
    public Consumer<StudentDTO> mapperEntityToDto(Student student){
        return studentDTO -> {
            studentDTO.setYearStudy(DateUtils.convertDateToString(student.getYearStudy()));
            studentDTO.setCreateAt(DateUtils.convertDateToString(student.getCreateAt()));
            studentDTO.setUpdateAt(DateUtils.convertDateToString(student.getUpdateAt()));
            BeanUtils.copyProperties(student, studentDTO);
        };
    }
}
