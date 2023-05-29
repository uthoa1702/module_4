package com.example.song_information.DTO;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

//Tên bài hát. Yêu cầu validate:
//
//Không được phép để trống
//
//Không vượt quá 800 ký tự
//
//Không chứa các kí tự đặc biệt như @ ; , . = - + , ….
//
//Nghệ sĩ thể hiện. Yêu cầu validate:
//
//Không được phép để trống
//
//Không quá 300 ký tự
//
//Không chứa các kí tự đặc biệt như @ ; , . = - + , ….
//
//Thể loại nhạc (nhập thông tin theo dạng text). Yêu cầu validate:
//
//Không được phép để trống
//
//Không vượt quá 1000 ký tự
//
//Ngoại trừ dấu phẩy “,” , các ký tự đặc biệt còn lại không được phép lưu vào DB


public class SongDTO implements Validator {
    private Integer id;


    @NotBlank(message = "This is required")
    @Size(max = 800,message = "Maximum 800 characters")
    @Pattern(regexp = "^([A-Z][a-z]*)(\\s[A-Z][a-z]*)*$", message = "Please check name format")


    private String name ;
    @NotBlank(message = "This is required")
    @Size(max = 300,message = "Maximum 300 characters")
    @Pattern(regexp = "^([A-Z][a-z]*)(\\s[A-Z][a-z]*)*$", message = "Please check name format")
    private String artist;


    @Size(max = 1000,message = "Maximum 1000 characters")
    @NotBlank(message = "This is required")
    @Column(name = "category", columnDefinition = "TEXT")
    @Pattern(regexp = "^([A-Za-z0-9,]*)(\\s[A-Za-z0-9,]*)*$", message = "Please check name format")
    private String category;

    public SongDTO() {
    }

    public SongDTO(Integer id, String name, String artist, String category) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.category = category;
    }

    public SongDTO(String name, String artist, String category) {
        this.name = name;
        this.artist = artist;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
