package com.gridbetjavaa.gridbetjavaa.model;

import jakarta.persistence.*;

@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(name = "email",nullable=false)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String email) {
        this.name = email;
    }

    // Default constructor without any arguments
    public Game() {
    }

    public Game(String name){
        this.name = name;
    }
}