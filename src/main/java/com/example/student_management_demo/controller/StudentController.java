package com.example.student_management_demo.controller;


import com.example.student_management_demo.dto.StudentSignUpDto;
import com.example.student_management_demo.models.Student;
import com.example.student_management_demo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<String> signUp(@RequestBody StudentSignUpDto studentSignUpDto){
        studentService.studentSignUp(studentSignUpDto);
        return new ResponseEntity<>("sign up successfully", HttpStatus.CREATED);
    }
}
