package com.example.first.controller;


import com.example.first.model.Class;
import com.example.first.model.Student;
import com.example.first.service.IClassService;
import com.example.first.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {
    @Autowired private IStudentService iStudentService;
    @Autowired private IClassService iClassService;

    @GetMapping("/")
    public String showList(Model model){
        List<Student> list = iStudentService.findAll();
        model.addAttribute("studentList",list);
        return "list";
    }


    @PostMapping("/delete")
    public String delete(Model model, @RequestParam("id")Long studentId){
        Student student = iStudentService.findById(studentId);
        student.setIs_delete(true);
        iStudentService.save(student);
        return "redirect:/";
    }

    @GetMapping("/create")
    public String create(Model model){
        List<Class>classList = iClassService.findAll();
        model.addAttribute("student", new Student());
        model.addAttribute("classList",classList);
        return "create";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("student")Student student, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "create";
        }
        iStudentService.save(student);
        return "redirect:/";
    }

    @GetMapping("/search")
    public String search(Model model, @RequestParam("studentName")String studentName, @RequestParam("className")String className){
        List<Student> studentList = iStudentService.search('%'+ studentName + '%', '%' + className + '%');
        model.addAttribute("studentList", studentList);
        model.addAttribute("className", className);
        model.addAttribute("studentName", studentName);
        return "list";
    }
}
