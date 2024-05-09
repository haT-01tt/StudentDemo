package com.tuanha.spring.project.studentprojectspringdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class StudentProjectSpringDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentProjectSpringDemoApplication.class, args);
    }

}
