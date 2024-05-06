package com.tuanha.spring.project.studentprojectspringdemo.Controller;

import com.tuanha.spring.project.studentprojectspringdemo.Dto.ParentDTO;
import com.tuanha.spring.project.studentprojectspringdemo.Entity.Parent;
import com.tuanha.spring.project.studentprojectspringdemo.Enum.ExceptionCode;
import com.tuanha.spring.project.studentprojectspringdemo.Service.ParentService;
import com.tuanha.spring.project.studentprojectspringdemo.Utils.ResBody;
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
    public List<ParentDTO> getAllParentStudent() {
        return parentService.getAllParentStudent();
    }

    @PostMapping(value = "/save")
    public ResponseEntity<ResBody<Parent>> saveParentStudent (@RequestBody ParentDTO parentDTO) {
        try {
            return new ResponseEntity<>(
                    new ResBody (parentService.saveParentStudent(parentDTO),
                            ExceptionCode.ParentStudentMessage.PR_STU_001.getCode(),
                            ExceptionCode.ParentStudentMessage.PR_STU_001.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new ResBody(ExceptionCode.ParentStudentMessage.PR_STU_010.getCode(),
                            ExceptionCode.ParentStudentMessage.PR_STU_010.getMessage()));
        }
    }

    @GetMapping(value = "/{id}/get")
    public ResponseEntity<ResBody<ParentDTO>> getByIdParentStudent(@PathVariable("id") Integer id) {
        try {
            return new ResponseEntity<>(
                    new ResBody(parentService.getByIdParentStudent(id),
                            ExceptionCode.ParentStudentMessage.PR_STU_013.getCode(),
                            ExceptionCode.ParentStudentMessage.PR_STU_013.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResBody(ExceptionCode.ParentStudentMessage.PR_STU_014.getCode(),
                            ExceptionCode.ParentStudentMessage.PR_STU_014.getMessage()));
        }
    }

    @PostMapping(value = "/save-parent")
    public ResponseEntity<ResBody<Parent>> saveParent (@RequestBody ParentDTO parentDTO) {
        try {
            return new ResponseEntity<>(
                    new ResBody(parentService.saveParent(parentDTO),
                            ExceptionCode.ParentStudentMessage.PR_STU_001.getCode(),
                            ExceptionCode.ParentStudentMessage.PR_STU_001.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new ResBody(ExceptionCode.ParentStudentMessage.PR_STU_010.getCode(),
                            ExceptionCode.ParentStudentMessage.PR_STU_010.getMessage()));
        }
    }
}
