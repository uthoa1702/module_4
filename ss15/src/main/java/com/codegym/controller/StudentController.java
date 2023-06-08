package com.codegym.controller;

import com.codegym.dto.StudentCreateDTO;
import com.codegym.model.Student;
import com.codegym.service.IClassRoomService;
import com.codegym.service.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("studentTalkList")
//Tương đương với URLPattern/value ở module 3
@RequestMapping("student")
public class StudentController {

//    @RequestMapping(value = "/hello")
    //Lấy: list, detail, search,..
//    @GetMapping("/")
    //Tạo
//    @PostMapping
    //Cập nhật toàn bộ 1 object
//    @PutMapping
////    Cập nhật 1 phần hoặc toàn bộ object
//    @PatchMapping
//
//    //Xóa
//    @DeleteMapping

//    @GetMapping(consumes = "text/html", produces = "text/html", params = {})

    @Autowired
    private IStudentService iStudentService;

    @Autowired
    private IClassRoomService iClassRoomService;

    @ModelAttribute("studentTalkList")
    public List<Student> initStudentTalkList() {
        return new ArrayList<>();
    }

    @GetMapping("/add-room/{id}")
    public String addRoom(@PathVariable("id")Integer codeStudent,
                          RedirectAttributes redirect,
                          @ModelAttribute("studentTalkList")List<Student> students) {
        Student student = iStudentService.getStudentById(codeStudent);
        students.add(student);
        redirect.addFlashAttribute("msg", "Add room successfully");
        return "redirect:/student";
    }
    @GetMapping("")
    public ModelAndView displayList(@RequestParam(value = "page", defaultValue = "0") int page) throws Exception {
//        throw new Exception();
        return new ModelAndView("list", "students", iStudentService.getAllPage(page));
    }

    @GetMapping("/create")
    public String viewCreate(Model model) {
//        String[] genders = new String[] {"Nam", "Nữ", "Khác"};
//        model.addAttribute("genders", genders);
        model.addAttribute("classrooms", iClassRoomService.findAll());
        model.addAttribute("studentCreateDTO", new StudentCreateDTO());
        return "create";
    }

    @GetMapping("/detail")
    public String detailByParam(@RequestParam Integer codeStudent,
                                Model model) {
        Student student = iStudentService.getStudentById(codeStudent);
        model.addAttribute("student", student);
        return "detail";
    }

    @GetMapping("/detail/{id}")
    public String detailByPathVariable(@PathVariable("id") Integer codeStudent,
                                       Model model) {
        Student student = iStudentService.getStudentById(codeStudent);
        model.addAttribute("student", student);
        return "detail";
    }


    //@ModelAttribute
//    @PostMapping("/create")
//    public String createStudent(@RequestParam Integer codeStudent,
//                                @RequestParam String nameStudent,
//                                @RequestParam Double point,
//                                @RequestParam Integer gender, RedirectAttributes redirect) {
//        Student student = new Student(codeStudent, nameStudent, point, gender);
//        redirect.addFlashAttribute("msg", "Add student successfully");
//        iStudentService.save(student);
//        return "redirect:/student";
//    }

    @PostMapping("/create")
    public String createStudent(@CookieValue("countStudent") Integer countStudent, HttpServletResponse response, Model model, @Validated @ModelAttribute("studentCreateDTO") StudentCreateDTO studentCreateDTO, BindingResult bindingResult, RedirectAttributes redirect) {
//        Student student = new Student(codeStudent, nameStudent, point, gender);
        new StudentCreateDTO().validate(studentCreateDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("classrooms", iClassRoomService.findAll());
            return "create";
        }
        redirect.addFlashAttribute("msg", "Add student successfully");
//        Student student = new Student(studentCreateDTO.getCodeStudent(), )
        Student student = new Student();
        //Yeeu cầu khi mapping: Trùng tên và kiểu dữ liệu của thuộc tính.
        BeanUtils.copyProperties(studentCreateDTO, student);

        Cookie cookie = new Cookie("countStudent", countStudent + 1 + "");
        cookie.setMaxAge(60 * 60 * 24 * 5);
        response.addCookie(cookie);
        iStudentService.save(student);
        return "redirect:/student";
    }

    @ExceptionHandler({Exception.class})
    public String handler() {
        return "error";
    }

}
