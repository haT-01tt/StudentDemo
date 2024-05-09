package com.tuanha.spring.project.studentprojectspringdemo.service;

import com.tuanha.spring.project.studentprojectspringdemo.dto.ParentDto;
import com.tuanha.spring.project.studentprojectspringdemo.dto.ParentStudentDto;
import com.tuanha.spring.project.studentprojectspringdemo.dto.StudentDto;
import com.tuanha.spring.project.studentprojectspringdemo.entity.Parent;
import com.tuanha.spring.project.studentprojectspringdemo.entity.Student;
import com.tuanha.spring.project.studentprojectspringdemo.mapper.FnMapper;
import com.tuanha.spring.project.studentprojectspringdemo.mapper.ParentMapper;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import com.tuanha.spring.project.studentprojectspringdemo.exceptionstudent.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class ParentStudentService {
    ParentMapper parentMapper;
//    StudentMapper studentMapper;
    StudentService studentService;
    ParentService parentService;

    public List<ParentStudentDto> getAllParentStudent(Integer id) throws NotFoundException {
        ParentDto parentDTO = parentService.getAllById(id).orElseThrow(() -> new NoSuchElementException("Parent not found with ID: " + id));
        return studentService.getAllById(id).stream().map(dto ->
                FnMapper.mapperBiEntityDto(ParentStudentDto::new, psd -> {
                    psd.setParentDTO(parentDTO);
                    psd.setStudentDTO(List.of(dto));
                }).apply(parentDTO, dto)).collect(Collectors.toList());
    }

    @Transactional
    public ParentStudentDto save(ParentStudentDto parentStudentDTO) {
        return listParentStudentDTO(parentStudentDTO)
                .apply(getParent(parentStudentDTO)
                        , getStudent(parentStudentDTO,
                                getParent(parentStudentDTO).getId()));
    }

    private List<Student> getStudent(ParentStudentDto parentStudentDTO, Integer parentId){
        parentStudentDTO.getStudentDTO().forEach(studentDTO -> studentDTO.setIdParent(parentId));
        return studentService.saveStudents(parentStudentDTO.getStudentDTO());
    }
    private Parent getParent(ParentStudentDto parentStudentDTO){
        return parentService.saveParentStudent(parentStudentDTO.getParentDTO());
    }

    private BiFunction<Parent, List<Student>, ParentStudentDto> listParentStudentDTO(ParentStudentDto parentStudentDTO) {
        return (parent, student) -> {
            parentStudentDTO.setParentDTO(parentMapper.entityToDTO().apply(parent));
            parentStudentDTO.setStudentDTO(FnMapper.<Student, StudentDto>mapperList(StudentDto::new).apply(student));
            return parentStudentDTO;
        };
    }
}
