package com.example.first.repository;

import com.example.first.model.LoaiTin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILoaiTinRepository extends JpaRepository<LoaiTin,Integer> {
}
