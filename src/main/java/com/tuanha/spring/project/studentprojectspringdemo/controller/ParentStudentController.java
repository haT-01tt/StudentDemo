package com.tuanha.spring.project.studentprojectspringdemo.controller;

import com.tuanha.spring.project.studentprojectspringdemo.dto.ParentStudentDto;
import com.tuanha.spring.project.studentprojectspringdemo.entity.Parent;
import com.tuanha.spring.project.studentprojectspringdemo.enumstudent.ExceptionCode;
import com.tuanha.spring.project.studentprojectspringdemo.service.ParentStudentService;
import com.tuanha.spring.project.studentprojectspringdemo.utils.ResBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.tuanha.spring.project.studentprojectspringdemo.enumstudent.ExceptionCode.ParentStudentMessage.PR_STU_013;

@RestController
@RequestMapping("/api/parent-student")
public class ParentStudentController {
    @Autowired
    ParentStudentService service;
    @GetMapping("/{id}/get-all")
    public ResponseEntity<ResBody<List<ParentStudentDto>>> getParentStudentDTOS(@PathVariable("id") Integer id) throws NotFoundException {
        return new ResponseEntity<>(new ResBody<>(service.getAllParentStudent(id),PR_STU_013.getCode(), PR_STU_013.getMessage()), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ResBody<Parent>> saveParentStudent(@RequestBody ParentStudentDto parentStudentDTO) {
        try {
            return new ResponseEntity<>(
                    new ResBody(service.save(parentStudentDTO),
                            ExceptionCode.ParentStudentMessage.PR_STU_001.getCode(),
                            ExceptionCode.ParentStudentMessage.PR_STU_001.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new ResBody(ExceptionCode.ParentStudentMessage.PR_STU_010.getCode(),
                            ExceptionCode.ParentStudentMessage.PR_STU_010.getMessage()));
        }
    }
}
