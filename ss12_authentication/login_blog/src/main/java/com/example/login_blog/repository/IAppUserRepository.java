package com.example.login_blog.repository;


import com.example.login_blog.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppUserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByUserName(String username);
}
