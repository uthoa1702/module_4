package com.example.first.service.impl;

import com.example.first.model.Tin;
import com.example.first.repository.ITinRepository;
import com.example.first.service.ITinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TinService implements ITinService {
    @Autowired private ITinRepository iTinRepository;

    @Override
    public List<Tin> findAll() {
        return iTinRepository.findAll();
    }

    @Override
    public void save(Tin tin) {
        iTinRepository.save(tin);
    }

    @Override
    public void delete(Integer id) {
        iTinRepository.deleteById(id);
    }

    @Override
    public List<Tin> search(String tieuDe, Integer loaiTinId) {
        return iTinRepository.search(tieuDe, loaiTinId);
    }
}
