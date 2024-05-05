package com.tuanha.spring.project.studentprojectspringdemo.Service;

import com.tuanha.spring.project.studentprojectspringdemo.Dto.StudentDTO;
import com.tuanha.spring.project.studentprojectspringdemo.Entity.Student;
import com.tuanha.spring.project.studentprojectspringdemo.Repo.GenericService;
import com.tuanha.spring.project.studentprojectspringdemo.Repo.MappingEntityToDTO;
import com.tuanha.spring.project.studentprojectspringdemo.StudentException;
import com.tuanha.spring.project.studentprojectspringdemo.Utils.DateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService implements MappingEntityToDTO<StudentDTO, Student> {
    @Autowired
    private final GenericService<Student> service;

    public Student saveStudent(StudentDTO studentDTO){
        return service.save(this.dtoEntity().apply(studentDTO));
    }
    public List<StudentDTO> getAllStudent(){
        List<Student> students = service.findAll(Student.class);
        return entityDTO().apply(students);
    }
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

    public Function<List<Student>, List<StudentDTO>> entityDTO() {
        return entity -> entity.stream().map(student -> {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setYearStudy(DateUtils.convertDateToString(student.getYearStudy()));
            studentDTO.setCreateAt(DateUtils.convertDateToString(student.getCreateAt()));
            studentDTO.setUpdateAt(DateUtils.convertDateToString(student.getUpdateAt()));
            BeanUtils.copyProperties(student, studentDTO);
            return studentDTO;
        }).collect(Collectors.toList());
    }
}
