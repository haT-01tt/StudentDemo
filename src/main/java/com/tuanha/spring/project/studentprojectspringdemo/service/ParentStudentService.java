package com.tuanha.spring.project.studentprojectspringdemo.service;

import com.tuanha.spring.project.studentprojectspringdemo.dto.ParentDTO;
import com.tuanha.spring.project.studentprojectspringdemo.dto.ParentStudentDTO;
import com.tuanha.spring.project.studentprojectspringdemo.dto.StudentDTO;
import com.tuanha.spring.project.studentprojectspringdemo.entity.Parent;
import com.tuanha.spring.project.studentprojectspringdemo.entity.Student;
import com.tuanha.spring.project.studentprojectspringdemo.mapper.ParentMapper;
import com.tuanha.spring.project.studentprojectspringdemo.mapper.StudentMapper;
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
    StudentMapper studentMapper;
    StudentService studentService;
    ParentService parentService;

    public List<ParentStudentDTO> getAllParentStudent(Integer id) throws NotFoundException {
        ParentDTO parentDTO = parentService.getAllById(id).orElseThrow(NotFoundException::new);
        List<StudentDTO> studentDTOS = studentService.getAllById(List.of(parentDTO.getIdStudent()));
        return studentDTOS.stream().map(dto ->
                createParentStudentDTO().apply(parentDTO, dto)).collect(Collectors.toList());
    }

    public ParentStudentDTO save(ParentStudentDTO parentStudentDTO) {
        List<Student> students = studentService.saveStudents(parentStudentDTO.getStudentDTO());
        students.forEach(student -> parentStudentDTO.getParentDTO().setIdStudent(student.getId()));
        return listParentStudentDTO(parentStudentDTO).apply(parentService.saveParentStudent(parentStudentDTO.getParentDTO()), students);
    }

    private BiFunction<ParentDTO, StudentDTO, ParentStudentDTO> createParentStudentDTO() {
        return (parent, student) -> {
            ParentStudentDTO parentStudentDTO = new ParentStudentDTO();
            parentStudentDTO.setParentDTO(parent);
            parentStudentDTO.setStudentDTO(Collections.singletonList(student));
            return parentStudentDTO;
        };
    }

    private BiFunction<Parent, List<Student>, ParentStudentDTO> listParentStudentDTO(ParentStudentDTO parentStudentDTO) {
        return (parent, student) -> {
            parentStudentDTO.setParentDTO(parentMapper.entityToDTO().apply(parent));
            parentStudentDTO.setStudentDTO(studentMapper.listEntityToDTO().apply(student));
            return parentStudentDTO;
        };
    }
}
