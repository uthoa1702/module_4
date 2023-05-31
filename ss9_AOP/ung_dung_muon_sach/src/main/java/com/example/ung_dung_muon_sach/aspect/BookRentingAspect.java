package com.example.ung_dung_muon_sach.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Aspect
@Component
public class BookRentingAspect {
    private static int count = 0;

    @After(value = "execution(* com.example.ung_dung_muon_sach.controller.RentalBookController.*(..))")
    public void logReturn(JoinPoint joinPoint) {
        File file = new File("D:\\module_4\\ss9_AOP\\ung_dung_muon_sach\\src\\main\\resources\\log\\log.csv");
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(joinPoint.getSignature().getName());
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterReturning(value = "execution(* com.example.ung_dung_muon_sach.controller.RentalBookController.returnBook(..))", returning = "result")
    public void logBorrow(JoinPoint joinPoint, Object result) {
        File file = new File("D:\\module_4\\ss9_AOP\\ung_dung_muon_sach\\src\\main\\resources\\log\\log.csv");
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(joinPoint.getSignature().getName());
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @After(value = "execution(* com.example.ung_dung_muon_sach.controller.RentalBookController.*(..))")
    public void logUserVisit(JoinPoint joinPoint) {
        File file = new File("D:\\module_4\\ss9_AOP\\ung_dung_muon_sach\\src\\main\\resources\\log\\visit.csv");
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        count++;
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(count);
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

