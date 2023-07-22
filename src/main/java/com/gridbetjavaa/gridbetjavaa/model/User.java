package com.gridbetjavaa.gridbetjavaa.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usertable")
public class User {

    @Id
    @SequenceGenerator(
            name= "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
    @Column(name = "email",nullable=false)
    private String email;
    @Column(name = "password",nullable=false)
    private String password;

    @Column(name = "credit",columnDefinition = "FLOAT default 0.0")
    private Float credit;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getFirstName() {
        return email;
    }

    public void setFirstName(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Float getCredit(){
        return credit;
    }

    public void setCredit(Float Credit){
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", email='" + email + '\'' + ", lastName='" + password
                + '\'' + '}';
    }
}

