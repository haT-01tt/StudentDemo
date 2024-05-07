package com.tuanha.spring.project.studentprojectspringdemo.controller;

import com.tuanha.spring.project.studentprojectspringdemo.dto.StudentDto;
import com.tuanha.spring.project.studentprojectspringdemo.entity.Student;
import com.tuanha.spring.project.studentprojectspringdemo.enumstudent.ExceptionCode;
import com.tuanha.spring.project.studentprojectspringdemo.exceptionstudent.StudentException;
import com.tuanha.spring.project.studentprojectspringdemo.service.StudentService;
import com.tuanha.spring.project.studentprojectspringdemo.utils.ResBody;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/getAll")
    public ResponseEntity<ResBody<Page<StudentDto>>> getAllStudent(@RequestParam(defaultValue = "0") int page,
                                                                   @RequestParam(defaultValue = "10") int size) {
        return new ResponseEntity<>(
                        new ResBody<>(studentService.getAllStudent(PageRequest.of(page,size))
                                , ExceptionCode.StudentMessage.STU_013.getCode(),
                                ExceptionCode.StudentMessage.STU_013.getMessage()), HttpStatus.OK);
    }

    @PostMapping(value = "/save-student")
    public ResponseEntity<ResBody<Student>> saveStudent(@Valid @RequestBody StudentDto studentDTO) throws StudentException {
            return new ResponseEntity<>(
                    new ResBody<>(studentService.saveStudent(studentDTO),
                            ExceptionCode.StudentMessage.STU_001.getCode(),
                            ExceptionCode.StudentMessage.STU_001.getMessage()), HttpStatus.OK);
    }

    @PostMapping(value = "/{id}/get-student")
    public ResponseEntity<ResBody<StudentDto>> getByIdStudent(@PathVariable("id") Integer id) {
        return
                new ResponseEntity<>(
                        new ResBody<>(studentService.getByIdStudent(id),
                                ExceptionCode.StudentMessage.STU_013.getCode(),
                                ExceptionCode.StudentMessage.STU_013.getMessage()), HttpStatus.OK);
    }

}
