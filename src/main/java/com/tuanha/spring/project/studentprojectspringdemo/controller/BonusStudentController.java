package com.tuanha.spring.project.studentprojectspringdemo.controller;


import com.tuanha.spring.project.studentprojectspringdemo.dto.BonusStudentModelDto;
import com.tuanha.spring.project.studentprojectspringdemo.entity.BonusStudent;
import com.tuanha.spring.project.studentprojectspringdemo.service.BonusStudentService;
import com.tuanha.spring.project.studentprojectspringdemo.utils.ResBody;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.tuanha.spring.project.studentprojectspringdemo.enumstudent.ExceptionCode.IN;
@RestController
@RequestMapping("/api/bonus")
public class BonusStudentController {
    @Autowired
    BonusStudentService service;

    @PostMapping(value = "/save")
    public ResponseEntity<ResBody<BonusStudent>> saveBonus(@Valid @RequestBody BonusStudentModelDto dto){
        return new ResponseEntity<>(new ResBody<>(service.saveBonus(dto), IN.getCode(), IN.getMessage()), HttpStatus.OK);
    }
}
