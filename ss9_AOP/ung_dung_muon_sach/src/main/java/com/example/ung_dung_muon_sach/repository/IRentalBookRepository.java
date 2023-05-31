package com.example.ung_dung_muon_sach.repository;

import com.example.ung_dung_muon_sach.model.BookRenting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRentalBookRepository extends JpaRepository<BookRenting,Integer> {
}
