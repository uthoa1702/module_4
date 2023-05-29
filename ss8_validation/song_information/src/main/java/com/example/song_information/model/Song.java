package com.example.song_information.model;

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
@Entity

public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name ;

    private String artist;

    @Column(name = "category", columnDefinition = "TEXT")
    private String category;

    public Song() {
    }

    public Song(Integer id, String name, String artist, String category) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.category = category;
    }

    public Song(String name, String artist, String category) {
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
}
