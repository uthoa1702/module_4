package com.example.sign_up_form.DTO;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class UserDTO implements Validator {
    private Integer id;
    @NotBlank(message = "This field is mandatory")
    @Size(max = 45,message = "maximum 45 characters")
//    @NameFormat(message = "The last name is invalid")
    @Pattern(regexp = "^([A-Z])([a-z])*((\\s)[A-Z]([a-z]*)){0,4}$", message = "The last name is invalid")
    private String lastName;

    private String firstName;
    @NotNull
    private String birthDay;

    @Email
    @NotNull
    private String email;
    @Pattern(regexp = "^0[0-9]{9,10}$" , message = "Phone number is invalid")
    @NotBlank(message = "Phone number is required")
    private String phone;

    public UserDTO(Integer id, String lastName, String firstName, String birthDay, String email, String phone) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDay = birthDay;
        this.email = email;
        this.phone = phone;
    }

    public UserDTO() {
    }

    public UserDTO(Integer id) {
        this.id = id;
    }

    public UserDTO(String lastName, String firstName, String birthDay, String email, String phone) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDay = birthDay;
        this.email = email;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDTO user = (UserDTO) target;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate age = LocalDate.parse( user.birthDay, formatter);
            LocalDate now = LocalDate.now();
            int yearOld = Period.between(age, now).getYears();
            if (yearOld < 18) {
                errors.rejectValue("birthDay", "","You must be older than 18 years old");
            }
        } catch (DateTimeParseException e) {
            errors.rejectValue("birthDay", "","format error ");
        }
    }
//    @Override
//    public void validate(Object target, Errors errors) {
//        FormRegisterDTO form = (FormRegisterDTO) target;
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        try {
//            LocalDate age = LocalDate.parse( form.age, formatter);
//            LocalDate now = LocalDate.now();
//            int yearOld = Period.between(age, now).getYears();
//            if (yearOld < 18) {
//                errors.rejectValue("age", "","Tuổi tối thiểu là 18 vui lòng kiểm tra lại");
//            }
//        } catch (DateTimeParseException e) {
//            errors.rejectValue("age", "","Định dạng ngày không hợp lệ, vui lòng kiểm tra lại");
//        }
//    }
}
