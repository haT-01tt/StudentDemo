package com.tuanha.spring.project.studentprojectspringdemo.controller;

import com.tuanha.spring.project.studentprojectspringdemo.dto.ParentDto;
import com.tuanha.spring.project.studentprojectspringdemo.entity.Parent;
import com.tuanha.spring.project.studentprojectspringdemo.enumstudent.ExceptionCode;
import com.tuanha.spring.project.studentprojectspringdemo.service.ParentService;
import com.tuanha.spring.project.studentprojectspringdemo.utils.ResBody;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/parent")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ParentController {
    ParentService parentService;

    @GetMapping(value = "/getAll")
    public List<ParentDto> getAllParentStudent() {
        return parentService.getAllParentStudent();
    }

    @PostMapping(value = "/save")
    public ResponseEntity<ResBody<Parent>> saveParentStudent (@RequestBody ParentDto parentDTO) {
            return new ResponseEntity<>(
                    new ResBody<> (parentService.saveParentStudent(parentDTO),
                            ExceptionCode.ParentStudentMessage.PR_STU_001.getCode(),
                            ExceptionCode.ParentStudentMessage.PR_STU_001.getMessage()), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/get")
    public ResponseEntity<ResBody<ParentDto>> getByIdParentStudent(@PathVariable("id") Integer id) {
            return new ResponseEntity<>(
                    new ResBody<>(parentService.getByIdParentStudent(id),
                            ExceptionCode.ParentStudentMessage.PR_STU_013.getCode(),
                            ExceptionCode.ParentStudentMessage.PR_STU_013.getMessage()), HttpStatus.OK);
    }

    @PostMapping(value = "/save-parent")
    public ResponseEntity<ResBody<Parent>> saveParent (@RequestBody ParentDto parentDTO) {
            return new ResponseEntity<>(
                    new ResBody<>(parentService.saveParent(parentDTO),
                            ExceptionCode.ParentStudentMessage.PR_STU_001.getCode(),
                            ExceptionCode.ParentStudentMessage.PR_STU_001.getMessage()), HttpStatus.OK);
    }
}
