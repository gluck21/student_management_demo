package com.example.student_management_demo.repositories;

import com.example.student_management_demo.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

    List<Subject> findSubjectByStudentId(Long studentId);
}
