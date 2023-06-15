package com.example.first.repository;

import com.example.first.model.TypeProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITypeProductRepository extends JpaRepository<TypeProduct,Integer> {
}
