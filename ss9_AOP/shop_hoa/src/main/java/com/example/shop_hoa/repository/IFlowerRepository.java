package com.example.shop_hoa.repository;

import com.example.shop_hoa.model.Flower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFlowerRepository extends JpaRepository<Flower,Integer> {
}
