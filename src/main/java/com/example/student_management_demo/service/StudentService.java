package com.example.student_management_demo.service;

import com.example.student_management_demo.dto.StudentResponseDto;
import com.example.student_management_demo.dto.StudentSignUpDto;
import com.example.student_management_demo.models.Student;

import java.util.List;

public interface StudentService {
    Student studentSignUp(StudentSignUpDto studentSignUpDto);
    List<StudentResponseDto> getAllStudents();
    StudentResponseDto getStudent(Long studentId);
    void deleteStudent(Long studentId);
}
