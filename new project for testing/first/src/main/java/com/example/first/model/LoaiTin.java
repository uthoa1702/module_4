package com.example.first.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LoaiTin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String tenLoai;

    public LoaiTin() {
    }

    public LoaiTin(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public LoaiTin(Integer id, String tenLoai) {
        this.id = id;
        this.tenLoai = tenLoai;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }
}
