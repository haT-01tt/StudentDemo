package com.tuanha.spring.project.studentprojectspringdemo;

import com.tuanha.spring.project.studentprojectspringdemo.dto.StudentDto;
import com.tuanha.spring.project.studentprojectspringdemo.service.StudentService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class StudentProjectSpringDemoApplicationTests {

    @InjectMocks
    private StudentService studentService;

    @Test
    void contextLoads() {
    }

    @Test
    public void testFindAll() {
        List<StudentDto> result = studentService.getAllStudent();
        assertEquals(0, result.size());
    }

    @Test
    public void testInsertStudent(){
        StudentDto studentDTO = new StudentDto();
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
