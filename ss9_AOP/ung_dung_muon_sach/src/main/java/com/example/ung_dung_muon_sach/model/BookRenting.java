package com.example.ung_dung_muon_sach.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@EntityListeners(AuditingEntityListener.class)
@SQLDelete(sql = "UPDATE book_renting SET status = true WHERE id=?")
@Where(clause = "status=false")
public class BookRenting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rent_code_generator")
    @SequenceGenerator(name = "rent_code_generator", sequenceName = "rent_code_seq", initialValue = 10000, allocationSize = 1)
    @Column(unique = true)
    private Integer rentCode;

    @OneToOne
    private Book book;

    @CreationTimestamp
    @Column(updatable = false, columnDefinition = "TIMESTAMP DEFAULT now()")
    private LocalDateTime rentingDate;

    private Boolean status = false;

    public BookRenting() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRentCode() {
        return rentCode;
    }

    public void setRentCode(Integer rentCode) {
        this.rentCode = rentCode;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDateTime getRentingDate() {
        return rentingDate;
    }

    public void setRentingDate(LocalDateTime rentingDate) {
        this.rentingDate = rentingDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public BookRenting(Integer rentCode, Book book) {
        this.rentCode = rentCode;
        this.book = book;
    }

    public BookRenting(Integer id, Integer rentCode, Book book, LocalDateTime rentingDate, Boolean status) {
        this.id = id;
        this.rentCode = rentCode;
        this.book = book;
        this.rentingDate = rentingDate;
        this.status = status;
    }
}