package com.example.hom_thu_dien_tu.service.impl;

import com.example.hom_thu_dien_tu.model.EmailContainer;
import com.example.hom_thu_dien_tu.repository.IEmailContainerRepository;
import com.example.hom_thu_dien_tu.service.IEmailContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailContainerService implements IEmailContainerService {
    @Autowired
    IEmailContainerRepository emailContainerRepository;

    @Override
    public void save(EmailContainer emailContainer1) {
        emailContainerRepository.save(emailContainer1);
    }

    @Override
    public EmailContainer showSetting() {
        return emailContainerRepository.showSetting();
    }
}
