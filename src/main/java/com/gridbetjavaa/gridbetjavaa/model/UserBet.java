package com.gridbetjavaa.gridbetjavaa.model;


import jakarta.persistence.*;

@Entity
@Table(name = "userbet")
public class UserBet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "userId", nullable = false)
    private Long userId;
    @Column(name = "gameBetTo", nullable = false)
    private Long gameBetTo;

    @Column(name="amount", nullable = false)
    private Float amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGameBetTo() {
        return gameBetTo;
    }

    public void setGameBetTo(Long gameBetTo) {
        this.gameBetTo = gameBetTo;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    // Default constructor without any arguments
    public UserBet() {
    }

    public UserBet(Long id) {
        this.id = id;
    }
}