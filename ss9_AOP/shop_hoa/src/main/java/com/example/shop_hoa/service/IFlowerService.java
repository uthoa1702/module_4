package com.example.shop_hoa.service;

import com.example.shop_hoa.model.Flower;

import java.util.List;

public interface IFlowerService {
    List<Flower> getList();

    Flower findById(Integer id);
}
