package com.example.sign_up_form.model;



import javax.persistence.*;
;
@Entity
public class User  {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String lastName;

    private String firstName;
    private String BirthDay;

    private String email;
    private String phone;

    public User(Integer id, String lastName, String firstName, String birthDay, String email, String phone) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.BirthDay = birthDay;
        this.email = email;
        this.phone = phone;
    }

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(String lastName, String firstName, String birthDay, String email, String phone) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.BirthDay = birthDay;
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
        return BirthDay;
    }

    public void setBirthDay(String birthDay) {
        BirthDay = birthDay;
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


}
