package com.example.first.service.impl;

import com.example.first.model.LoaiTin;
import com.example.first.repository.ILoaiTinRepository;
import com.example.first.service.ILoaiTinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoaiTinService implements ILoaiTinService {
    @Autowired private ILoaiTinRepository iLoaiTinRepository;

    @Override
    public List<LoaiTin> findAll() {
        return iLoaiTinRepository.findAll();
    }
}
