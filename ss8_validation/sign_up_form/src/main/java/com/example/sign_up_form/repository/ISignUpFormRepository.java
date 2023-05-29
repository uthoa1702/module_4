package com.example.sign_up_form.repository;

import com.example.sign_up_form.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISignUpFormRepository extends JpaRepository<User,Integer> {
}
