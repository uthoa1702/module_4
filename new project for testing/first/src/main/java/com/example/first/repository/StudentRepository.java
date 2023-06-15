package com.example.first.repository;

import com.example.first.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    @Query(value = "select s from  Student  s where s.is_delete = false ")
    List<Student> findAllAll();


    @Query(value = "SELECT s.*\n" +
            "FROM student AS s\n" +
            "         INNER JOIN class c ON s.classes_id = c.id\n" +
            "WHERE S.name LIKE :studentName \n" +
            "  AND c.name LIKE :className \n" +
            "  AND s.is_delete = FALSE", nativeQuery = true)
    List<Student> search(@Param("studentName") String studentName,@Param("className") String className);
}
