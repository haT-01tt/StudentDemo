package com.tuanha.spring.project.studentprojectspringdemo.controller;

import com.tuanha.spring.project.studentprojectspringdemo.dto.BonusStudentDto;
import com.tuanha.spring.project.studentprojectspringdemo.entity.BonusStudent;
import com.tuanha.spring.project.studentprojectspringdemo.service.BonusStudentService;
import com.tuanha.spring.project.studentprojectspringdemo.utils.ResBody;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

import static com.tuanha.spring.project.studentprojectspringdemo.enumstudent.ExceptionCode.IN;
import static com.tuanha.spring.project.studentprojectspringdemo.enumstudent.ExceptionCode.FIND;
@RestController
@RequestMapping("/api/bonus")
public class BonusStudentController {
    @Autowired
    BonusStudentService service;

    @PostMapping(value = "/save")
    public ResponseEntity<ResBody<BonusStudent>> saveBonus(@Valid @RequestBody BonusStudentDto dto){
        return new ResponseEntity<>(new ResBody<>(service.saveBonus(dto), IN.getCode(), IN.getMessage()), HttpStatus.OK);
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<ResBody<List<BonusStudentDto>>> getAllBonus () {
        return new ResponseEntity<>(new ResBody<>(service.getAllBonus(), FIND.getCode(), FIND.getMessage()), HttpStatus.OK);
    }
}
