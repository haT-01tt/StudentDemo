package com.tuanha.spring.project.studentprojectspringdemo.Controller;

import com.tuanha.spring.project.studentprojectspringdemo.Dto.ParentStudentDTO;
import com.tuanha.spring.project.studentprojectspringdemo.Entity.Parent;
import com.tuanha.spring.project.studentprojectspringdemo.Enum.ExceptionErrorCode;
import com.tuanha.spring.project.studentprojectspringdemo.Service.ParentStudentService;
import com.tuanha.spring.project.studentprojectspringdemo.Utils.ResBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.tuanha.spring.project.studentprojectspringdemo.Enum.ExceptionErrorCode.ParentStudentMessage.PR_STU_013;

@RestController
@RequestMapping("/api/parent-student")
public class ParentStudentController {
    @Autowired
    ParentStudentService service;
    @GetMapping("/{id}/get-all")
    public ResponseEntity<ResBody<List<ParentStudentDTO>>> getParentStudentDTOS(@PathVariable("id") Integer id) throws NotFoundException {
        return new ResponseEntity<>(new ResBody<>(service.getAllParentStudent(id),PR_STU_013.getCode(), PR_STU_013.getMessage()), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ResBody<Parent>> saveParentStudent(@RequestBody ParentStudentDTO parentStudentDTO) {
        try {
            return new ResponseEntity<>(
                    new ResBody(service.save(parentStudentDTO),
                            ExceptionErrorCode.ParentStudentMessage.PR_STU_001.getCode(),
                            ExceptionErrorCode.ParentStudentMessage.PR_STU_001.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new ResBody(ExceptionErrorCode.ParentStudentMessage.PR_STU_010.getCode(),
                            ExceptionErrorCode.ParentStudentMessage.PR_STU_010.getMessage()));
        }
    }
}
