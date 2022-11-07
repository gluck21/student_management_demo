package com.example.student_management_demo.service.serviceImpl;

import com.example.student_management_demo.dto.StudentSignUpDto;
import com.example.student_management_demo.models.Student;
import com.example.student_management_demo.repositories.StudentRepository;
import com.example.student_management_demo.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


//@RequiredArgsConstructor
//@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student studentSignUp(StudentSignUpDto studentSignUpDto) {
        Student student = new Student();
        student.setName(studentSignUpDto.getName());
        student.setEmail(studentSignUpDto.getEmail());
        student.setPassword(studentSignUpDto.getPassword());
        return studentRepository.save(student);
    }
}
