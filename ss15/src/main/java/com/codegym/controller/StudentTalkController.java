package com.codegym.controller;

import com.codegym.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
public class StudentTalkController {

    @GetMapping("/student-talk")
    public String getAllList(Model model,
                             @SessionAttribute("studentTalkList") List<Student> list){
        model.addAttribute("studentTalkList", list);
        return "list_talk";
    }

}
