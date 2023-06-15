package com.example.first.service;

import com.example.first.model.TypeProduct;
import com.example.first.repository.ITypeProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeProductService implements ITypeProductService {
    @Autowired private ITypeProductRepository iTypeProductRepository;

    @Override
    public List<TypeProduct> findAll() {
        return iTypeProductRepository.findAll();
    }
}
