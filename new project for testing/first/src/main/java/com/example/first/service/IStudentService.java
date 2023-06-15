package com.example.first.service;

import com.example.first.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();

    Student findById(Long studentId);

    void save(Student student);

    List<Student> search(String studentName, String className );
}
