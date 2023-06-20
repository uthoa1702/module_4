package com.example.first.service;

import com.example.first.model.Tin;

import java.util.List;

public interface ITinService {
    List<Tin> findAll();

    void save(Tin tin);

    void delete(Integer id);

    List<Tin> search(String tieuDe, Integer loaiTinId);
}
