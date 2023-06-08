package com.codegym.repository;

import com.codegym.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface IStudentRepository extends JpaRepository<Student, Integer> {

//    List<Student> findAllByNameStudentContaining(String name);

//    HQL
//    @Query(value = "select s from Student s where s.nameStudent like :name")

//    SQL
    @Query(value = "select * from student as s where s.name_student like :name", nativeQuery = true)
    List<Student> getStudentByName(@Param("name") String name);

    //Nếu các bạn cập nhật dữ liệu
//    @Modifying
//    @Transactional
//    @Query


}
