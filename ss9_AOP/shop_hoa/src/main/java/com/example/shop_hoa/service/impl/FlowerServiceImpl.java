package com.example.shop_hoa.service.impl;

import com.example.shop_hoa.model.Flower;
import com.example.shop_hoa.repository.IFlowerRepository;
import com.example.shop_hoa.service.IFlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlowerServiceImpl implements IFlowerService {
    @Autowired
    private IFlowerRepository iFlowerRepository;
    @Override
    public List<Flower> getList() {
        return iFlowerRepository.findAll();
    }

    @Override
    public Flower findById(Integer id) {
        return iFlowerRepository.findById(id).get();
    }
}
