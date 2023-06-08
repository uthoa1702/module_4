package com.example.login_blog.model;

import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@SQLDelete(sql = "UPDATE pet_service SET is_delete = true WHERE id=?")
@Where(clause = "is_delete=false")
public class BookingService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingServiceId;



    // link voi customer id



    @NotNull
    private LocalDate bookingDate;

    @NotNull
    private String bookingTime;

    @Column(name = "createTime", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT now()")
    @CreationTimestamp
    private Date createTime;

    @Column(name = "updateTime", nullable = false, columnDefinition = "TIMESTAMP DEFAULT now()")
    @UpdateTimestamp
    private Date updateTime;


    public BookingService() {
    }

    public BookingService(Long id, LocalDate bookingDate, String bookingTime, Date createTime, Date updateTime) {
        this.bookingServiceId = id;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public BookingService(LocalDate bookingDate, String bookingTime) {
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
    }

    public Long getBookingServiceId() {
        return bookingServiceId;
    }

    public void setBookingServiceId(Long id) {
        this.bookingServiceId = id;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
