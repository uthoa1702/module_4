package com.example.first.service;

import com.example.first.model.Student;
import com.example.first.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService{
    @Autowired private StudentRepository studentRepository;
    @Override
    public List<Student> findAll() {
        return studentRepository.findAllAll();
    }

    @Override
    public Student findById(Long studentId) {
        return studentRepository.findById(studentId).get();
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> search(String studentName, String className) {
        return studentRepository.search( studentName,className);
    }
}
