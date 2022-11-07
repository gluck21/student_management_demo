package com.example.student_management_demo.repositories;

import com.example.student_management_demo.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
