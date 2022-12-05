package com.example.student_management_demo.controller;


import com.example.student_management_demo.dto.StudentResponseDto;
import com.example.student_management_demo.dto.StudentSignUpDto;
import com.example.student_management_demo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/")
    public ResponseEntity<List<StudentResponseDto>> getAllStudent(){
        List<StudentResponseDto> studentResponseDtoList = studentService.getAllStudents();
        return new ResponseEntity<>(studentResponseDtoList, HttpStatus.OK);
    }

    @GetMapping("/profile/{studentId}")
    public ResponseEntity<StudentResponseDto> getStudent(@PathVariable Long studentId){
        StudentResponseDto studentResponseDto = studentService.getStudent(studentId);
        return new ResponseEntity<>(studentResponseDto, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long studentId){
        studentService.deleteStudent(studentId);
        return new ResponseEntity<>("student deleted successfully", HttpStatus.NO_CONTENT);
    }
}
