package com.example.ung_dung_muon_sach;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.EntityListeners;

@SpringBootApplication
@EnableJpaRepositories
@EnableJpaAuditing
public class UngDungMuonSachApplication {

	public static void main(String[] args) {
		SpringApplication.run(UngDungMuonSachApplication.class, args);
	}

}
