package com.example.hom_thu_dien_tu.repository;

import com.example.hom_thu_dien_tu.model.EmailContainer;

public interface IEmailContainerRepository {
    void save(EmailContainer emailContainer1);

    EmailContainer showSetting();
}
