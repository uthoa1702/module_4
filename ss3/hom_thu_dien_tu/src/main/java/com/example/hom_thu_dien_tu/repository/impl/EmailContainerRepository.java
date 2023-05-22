package com.example.hom_thu_dien_tu.repository.impl;

import com.example.hom_thu_dien_tu.model.EmailContainer;
import com.example.hom_thu_dien_tu.repository.IEmailContainerRepository;
import org.springframework.stereotype.Repository;

@Repository
public class EmailContainerRepository implements IEmailContainerRepository {
    static EmailContainer emailContainer = new EmailContainer("English",5,true,"James");
    @Override
    public void save(EmailContainer emailContainer1) {
        emailContainer.setLanguage(emailContainer1.getLanguage());
        emailContainer.setPages(emailContainer1.getPages());
        emailContainer.setSpamFilter(emailContainer1.isSpamFilter());
        emailContainer.setSignature(emailContainer1.getSignature());
    }

    @Override
    public EmailContainer showSetting() {
        return emailContainer;
    }
}
