package com.example.sign_up_form.service.impl;

import com.example.sign_up_form.DTO.UserDTO;
import com.example.sign_up_form.model.User;
import com.example.sign_up_form.repository.ISignUpFormRepository;
import com.example.sign_up_form.service.ISignUpFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUpFormService implements ISignUpFormService {
    @Autowired
    private ISignUpFormRepository repository;


    @Override
    public void save(User userDTO) {
        repository.save(userDTO);
    }
}
