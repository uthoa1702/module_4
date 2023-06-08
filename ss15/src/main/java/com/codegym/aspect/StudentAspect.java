package com.codegym.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class StudentAspect {

    @After("execution(* com.codegym.controller.StudentController.*(..))")
    public void log(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName());
    }
}
