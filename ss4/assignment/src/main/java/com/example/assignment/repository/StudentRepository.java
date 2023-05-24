//package com.example.assignment.repository;
//
//import com.codegym.demo.model.Student;
//import com.codegym.demo.repository.IStudentRepository;
//import org.hibernate.Transaction;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityTransaction;
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public class StudentRepository implements IStudentRepository {
//    private static List<Student> students = new ArrayList<>();
//
//    static {
//        students.add(new Student(1, "haiTT", 9, 1));
//        students.add(new Student(2, "haiTT2", 3, 0));
//        students.add(new Student(3, "haiTT3", 6, 1));
//        students.add(new Student(4, "haiTT4", 8, null));
//        students.add(new Student(5, "haiTT5", 5, 1));
//    }
//
//    @Override
//    public List<Student> getAll() {
////        HQL
//        List<Student> students = BaseRepository.entityManager.createQuery("select s from Student s", Student.class).getResultList();
////        createNativeQuery => SQL
//        return students;
//    }
//
//    @Override
//    public void save(Student student) {
//        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
//        transaction.begin();
//        BaseRepository.entityManager.persist(student);
//        transaction.commit();
//    }
//
//    @Override
//    public Student getStudentById(int id) {
//        Student student = BaseRepository.entityManager.find(Student.class, id);
//        return student;
//    }
//}
