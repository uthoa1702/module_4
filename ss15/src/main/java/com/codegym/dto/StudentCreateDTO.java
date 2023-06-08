package com.codegym.dto;

import com.codegym.model.ClassRoom;
import com.codegym.utils.annotation.NameFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class StudentCreateDTO implements Validator {

    private Integer codeStudent;
    @Size(max = 100, message = "Tên không được dài hơn 100 kí tự")
    @NotBlank(message = "Tên không được để trống")
    @NameFormat
    private String nameStudent;
    @Min(value = 0, message = "Điểm không được nhỏ hơn 0")
    @NotNull(message = "Điểm không được để trống")
    private Double point;
    private Integer gender;

    private ClassRoom classRoom;

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    public StudentCreateDTO() {
    }

    public StudentCreateDTO(Integer codeStudent, String nameStudent, Double point, Integer gender) {
        this.codeStudent = codeStudent;
        this.nameStudent = nameStudent;
        this.point = point;
        this.gender = gender;
    }

    public Integer getCodeStudent() {
        return codeStudent;
    }

    public void setCodeStudent(Integer codeStudent) {
        this.codeStudent = codeStudent;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
          StudentCreateDTO studentCreateDTO = (StudentCreateDTO) target;
          String regex = "^[A-Za-z ]{1,100}$";
          if(!studentCreateDTO.nameStudent.matches(regex)) {
              errors.rejectValue("nameStudent", "", "Tên không đúng định dạng. Tên chỉ được chứa ký tự chữ và khoảng trắng.");
          }
    }
}
