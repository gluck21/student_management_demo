package com.example.student_management_demo.service;

import com.example.student_management_demo.dto.StudentSignUpDto;
import com.example.student_management_demo.models.Student;

public interface StudentService {
    Student studentSignUp(StudentSignUpDto studentSignUpDto);
}
