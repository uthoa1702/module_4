package com.example.first.DTO;

import com.example.first.model.LoaiTin;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

public class TinDTO {
    private Integer id;

    @NotBlank(message = "khong duoc de trong")
    private String tieuDe;

    @NotBlank(message = "khong duoc de trong")
    private String noiDung;

    private String ngayDang;


    private String ngayKetThuc;

    public TinDTO(Integer id, String tieuDe, String noiDung, String ngayDang, String ngayKetThuc) {
        this.id = id;
        this.tieuDe = tieuDe;
        this.noiDung = noiDung;
        this.ngayDang = ngayDang;
        this.ngayKetThuc = ngayKetThuc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getNgayDang() {
        return ngayDang;
    }

    public void setNgayDang(String ngayDang) {
        this.ngayDang = ngayDang;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }
}
