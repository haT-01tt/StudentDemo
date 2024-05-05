package com.tuanha.spring.project.studentprojectspringdemo.Controller;

import com.tuanha.spring.project.studentprojectspringdemo.Dto.StudentDTO;
import com.tuanha.spring.project.studentprojectspringdemo.Enum.ExceptionErrorCode;
import com.tuanha.spring.project.studentprojectspringdemo.Service.StudentService;
import com.tuanha.spring.project.studentprojectspringdemo.Utils.ResBody;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/getAll")
    public List<StudentDTO> getAllStudent(){
        return studentService.getAllStudent();
    }

    @PostMapping(value = "/save-student")
    public ResBody saveStudent(@RequestBody StudentDTO studentDTO){
        studentService.saveStudent(studentDTO);
        return new ResBody(ExceptionErrorCode.StudentMessage.STU_001.getCode()
                , ExceptionErrorCode.StudentMessage.STU_001.getMessage());
    }

}
