package com.tuanha.spring.project.studentprojectspringdemo.service;

import com.tuanha.spring.project.studentprojectspringdemo.dto.ParentDto;
import com.tuanha.spring.project.studentprojectspringdemo.dto.ParentStudentDto;
import com.tuanha.spring.project.studentprojectspringdemo.dto.StudentDto;
import com.tuanha.spring.project.studentprojectspringdemo.entity.Parent;
import com.tuanha.spring.project.studentprojectspringdemo.entity.Student;
import com.tuanha.spring.project.studentprojectspringdemo.mapper.ParentMapper;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
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
        ParentDto parentDTO = parentService.getAllById(id).orElseThrow(NotFoundException::new);
        List<StudentDto> studentDTOS = studentService.getAllById(List.of(parentDTO.getIdStudent()));
        return studentDTOS.stream().map(dto ->
                createParentStudentDTO().apply(parentDTO, dto)).collect(Collectors.toList());
    }

//    public ParentStudentDto save(ParentStudentDto parentStudentDTO) {
//        List<Student> students = studentService.saveStudents(parentStudentDTO.getStudentDTO());
//        students.forEach(student -> parentStudentDTO.getParentDTO().setIdStudent(student.getId()));
//        return listParentStudentDTO(parentStudentDTO).apply(parentService.saveParentStudent(parentStudentDTO.getParentDTO()), students);
//    }

    private BiFunction<ParentDto, StudentDto, ParentStudentDto> createParentStudentDTO() {
        return (parent, student) -> {
            ParentStudentDto parentStudentDTO = new ParentStudentDto();
            parentStudentDTO.setParentDTO(parent);
            parentStudentDTO.setStudentDTO(Collections.singletonList(student));
            return parentStudentDTO;
        };
    }

//    private BiFunction<Parent, List<Student>, ParentStudentDto> listParentStudentDTO(ParentStudentDto parentStudentDTO) {
//        return (parent, student) -> {
//            parentStudentDTO.setParentDTO(parentMapper.entityToDTO().apply(parent));
//            parentStudentDTO.setStudentDTO(studentMapper.listEntityToDTO().apply(student));
//            return parentStudentDTO;
//        };
//    }
}
