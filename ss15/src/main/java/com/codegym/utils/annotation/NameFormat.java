package com.codegym.utils.annotation;

import org.springframework.stereotype.Component;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = NamValidator.class)
public @interface NameFormat {
    String message () default "Tên không đúng định dạng.";
    Class<?> [] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
