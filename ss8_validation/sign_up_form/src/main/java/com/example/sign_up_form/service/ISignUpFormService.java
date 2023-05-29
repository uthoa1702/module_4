package com.example.sign_up_form.service;

import com.example.sign_up_form.DTO.UserDTO;
import com.example.sign_up_form.model.User;

public interface ISignUpFormService {
    void save(User userDTO);
}
