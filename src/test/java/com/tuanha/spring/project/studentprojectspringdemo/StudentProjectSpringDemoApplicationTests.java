package com.tuanha.spring.project.studentprojectspringdemo;

import com.tuanha.spring.project.studentprojectspringdemo.dto.StudentDto;
import com.tuanha.spring.project.studentprojectspringdemo.exceptionstudent.StudentException;
import com.tuanha.spring.project.studentprojectspringdemo.service.StudentService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.Assert;

import java.util.Collection;

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
        Pageable pageable = PageRequest.of(0,10);
        Page<StudentDto> result = studentService.getAllStudent(pageable);
        Assert.notEmpty((Collection<?>) result, () -> "List not null");
    }

    @Test
    public void testInsertStudent() throws StudentException {
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
