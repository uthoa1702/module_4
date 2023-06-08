package com.codegym.utils.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NamValidator implements ConstraintValidator<NameFormat, String> {

    @Override
    public void initialize(NameFormat constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        return value.matches("^[A-Za-z ]{1,100}$");
    }
}
