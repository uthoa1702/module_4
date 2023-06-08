package com.codegym.controller;

import com.codegym.dto.StudentCreateDTO;
import com.codegym.model.Student;
import com.codegym.service.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/admin/student")
@CrossOrigin("*")
public class StudentRestController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @Autowired
    private IStudentService iStudentService;

    @GetMapping("")
    public ResponseEntity<List<Student>> getList() {
        return new ResponseEntity<>(iStudentService.getAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Void> addNewStudent(@Valid @RequestBody StudentCreateDTO studentCreateDTO) {
        Student student = new Student();
        BeanUtils.copyProperties(studentCreateDTO, student);
        iStudentService.save(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
