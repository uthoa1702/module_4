package com.codegym.service;


import com.codegym.model.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IStudentService {
    List<Student> getAll();

    void save(Student student);

    Student getStudentById(int id);

    Page<Student> getAllPage(int page);
}
