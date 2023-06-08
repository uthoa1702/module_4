package com.codegym.service.impl;

import com.codegym.model.ClassRoom;
import com.codegym.repository.IClassRoomRepository;
import com.codegym.service.IClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassRoomService implements IClassRoomService {

    @Autowired
    private IClassRoomRepository iClassRoomRepository;

    @Override
    public List<ClassRoom> findAll() {
        return  iClassRoomRepository.findAll();
    }
}
