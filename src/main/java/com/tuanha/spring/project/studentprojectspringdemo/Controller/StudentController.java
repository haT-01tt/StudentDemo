package com.tuanha.spring.project.studentprojectspringdemo.Controller;

import com.tuanha.spring.project.studentprojectspringdemo.Dto.StudentDTO;
import com.tuanha.spring.project.studentprojectspringdemo.Entity.Student;
import com.tuanha.spring.project.studentprojectspringdemo.Enum.ExceptionErrorCode;
import com.tuanha.spring.project.studentprojectspringdemo.Service.StudentService;
import com.tuanha.spring.project.studentprojectspringdemo.Utils.ResBody;
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
    public ResponseEntity<ResBody<List<StudentDTO>>> getAllStudent() {
        return
                new ResponseEntity<>(
                        new ResBody<>(studentService.getAllStudent(), ExceptionErrorCode.StudentMessage.STU_013.getCode(),
                                ExceptionErrorCode.StudentMessage.STU_013.getMessage()), HttpStatus.OK);
    }

    @PostMapping(value = "/save-student")
    public ResponseEntity<ResBody<Student>> saveStudent(@RequestBody StudentDTO studentDTO) {
        try {
            return new ResponseEntity<>(
                    new ResBody(studentService.saveStudent(studentDTO),
                            ExceptionErrorCode.StudentMessage.STU_001.getCode(),
                            ExceptionErrorCode.StudentMessage.STU_001.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new ResBody(ExceptionErrorCode.StudentMessage.STU_010.getCode(),
                            ExceptionErrorCode.StudentMessage.STU_010.getMessage()));
        }
    }

    @PostMapping(value = "/{id}/get-student")
    public ResponseEntity<ResBody<StudentDTO>> getByIdStudent(@PathVariable("id") Integer id) {
        try {
            return
                    new ResponseEntity<>(
                            new ResBody(studentService.getByIdStudent(id),
                                    ExceptionErrorCode.StudentMessage.STU_013.getCode(),
                                    ExceptionErrorCode.StudentMessage.STU_013.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResBody(
                    ExceptionErrorCode.StudentMessage.STU_014.getCode(),
                    ExceptionErrorCode.StudentMessage.STU_014.getMessage()));
        }
    }

}
