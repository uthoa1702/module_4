package com.example.ung_dung_blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EnableJpaAuditing
public class UngDungBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(UngDungBlogApplication.class, args);
	}

}
