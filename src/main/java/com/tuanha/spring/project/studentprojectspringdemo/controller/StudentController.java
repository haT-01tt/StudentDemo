package com.tuanha.spring.project.studentprojectspringdemo.controller;

import com.tuanha.spring.project.studentprojectspringdemo.dto.StudentDto;
import com.tuanha.spring.project.studentprojectspringdemo.entity.Student;
import com.tuanha.spring.project.studentprojectspringdemo.enumstudent.ExceptionCode;
import com.tuanha.spring.project.studentprojectspringdemo.service.StudentService;
import com.tuanha.spring.project.studentprojectspringdemo.utils.ResBody;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/getAll")
    public ResponseEntity<ResBody<List<StudentDto>>> getAllStudent() {
        return
                new ResponseEntity<>(
                        new ResBody<>(studentService.getAllStudent(), ExceptionCode.StudentMessage.STU_013.getCode(),
                                ExceptionCode.StudentMessage.STU_013.getMessage()), HttpStatus.OK);
    }

    @PostMapping(value = "/save-student")
    public ResponseEntity<ResBody<Student>> saveStudent(@Valid @RequestBody StudentDto studentDTO) {
        try {
            return new ResponseEntity<>(
                    new ResBody(studentService.saveStudent(studentDTO),
                            ExceptionCode.StudentMessage.STU_001.getCode(),
                            ExceptionCode.StudentMessage.STU_001.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new ResBody(ExceptionCode.StudentMessage.STU_010.getCode(),
                            ExceptionCode.StudentMessage.STU_010.getMessage()));
        }
    }

    @PostMapping(value = "/{id}/get-student")
    public ResponseEntity<ResBody<StudentDto>> getByIdStudent(@PathVariable("id") Integer id) {
        try {
            return
                    new ResponseEntity<>(
                            new ResBody(studentService.getByIdStudent(id),
                                    ExceptionCode.StudentMessage.STU_013.getCode(),
                                    ExceptionCode.StudentMessage.STU_013.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResBody(
                    ExceptionCode.StudentMessage.STU_014.getCode(),
                    ExceptionCode.StudentMessage.STU_014.getMessage()));
        }
    }

}
