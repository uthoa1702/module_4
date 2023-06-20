package com.example.first.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
public class Tin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "khong duoc de trong")
    private String tieuDe;

    @NotBlank(message = "khong duoc de trong")
    private String noiDung;

    @NotBlank(message = "khong duoc de trong")
    private String ngayDang;


    @NotBlank(message = "khong duoc de trong")
    private String ngayKetThuc;

    @ManyToOne
    @JoinColumn
    private LoaiTin loaiTin;

    public Tin() {
    }

    public Tin(String tieuDe, String noiDung, String ngayDang, String ngayKetThuc, LoaiTin loaiTin) {
        this.tieuDe = tieuDe;
        this.noiDung = noiDung;
        this.ngayDang = ngayDang;
        this.ngayKetThuc = ngayKetThuc;
        this.loaiTin = loaiTin;
    }

    public Tin(Integer id, String tieuDe, String noiDung, String ngayDang, String ngayKetThuc, LoaiTin loaiTin) {
        this.id = id;
        this.tieuDe = tieuDe;
        this.noiDung = noiDung;
        this.ngayDang = ngayDang;
        this.ngayKetThuc = ngayKetThuc;
        this.loaiTin = loaiTin;
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

    public LoaiTin getLoaiTin() {
        return loaiTin;
    }

    public void setLoaiTin(LoaiTin loaiTin) {
        this.loaiTin = loaiTin;
    }
}