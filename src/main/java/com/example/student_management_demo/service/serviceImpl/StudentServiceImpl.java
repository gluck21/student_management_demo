package com.example.student_management_demo.service.serviceImpl;

import com.example.student_management_demo.dto.StudentResponseDto;
import com.example.student_management_demo.dto.StudentSignUpDto;
import com.example.student_management_demo.models.Student;
import com.example.student_management_demo.repositories.StudentRepository;
import com.example.student_management_demo.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


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

    @Override
    public List<StudentResponseDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentResponseDto> studentResponseDtoList = new ArrayList<>();
//        for (Student student : students) {
//            StudentResponseDto studentResponseDto = new StudentResponseDto();
//            studentResponseDto.setId(student.getId());
//            studentResponseDto.setName(student.getName());
//            studentResponseDto.setEmail(student.getEmail());
//            studentResponseDtoList.add(studentResponseDto);
//        }
        students.forEach(student -> {
            StudentResponseDto studentResponseDto = new StudentResponseDto();
            studentResponseDto.setId(student.getId());
            studentResponseDto.setName(student.getName());
            studentResponseDto.setEmail(student.getEmail());
            studentResponseDtoList.add(studentResponseDto);
        });
        return studentResponseDtoList;
    }

    @Override
    public StudentResponseDto getStudent(Long studentId) {
        Student student = studentRepository.findById(studentId).get();
        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setId(student.getId());
        studentResponseDto.setName(student.getName());
        studentResponseDto.setEmail(student.getEmail());
        return studentResponseDto;
    }

    @Override
    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}
