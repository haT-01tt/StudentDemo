package com.tuanha.spring.project.studentprojectspringdemo;

import com.tuanha.spring.project.studentprojectspringdemo.Dto.StudentDTO;
import com.tuanha.spring.project.studentprojectspringdemo.Entity.Student;
import com.tuanha.spring.project.studentprojectspringdemo.Repo.GenericService;
import com.tuanha.spring.project.studentprojectspringdemo.Service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
class StudentProjectSpringDemoApplicationTests {

    @InjectMocks
    private StudentService studentService;

    @Test
    void contextLoads() {
    }

    @Test
    public void testFindAll() {
        List<StudentDTO> result = studentService.getAllStudent();
        assertEquals(0, result.size());
    }

    @Test
    public void testInsertStudent(){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentCode("STU-CDO-001");
        studentDTO.setName("Phuong Nguyen");
        studentDTO.setAddress("Lang Giang - Bac Giang");
        studentDTO.setPhoneNumber("0353709081");
        studentDTO.setYearStudy("01-01-2022");
        studentDTO.setCreateAt("05-05-2024");
        studentDTO.setUpdateAt(null);
        assertNotNull(studentService.saveStudent(studentDTO));
    }

}
