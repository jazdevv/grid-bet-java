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

    @Column(name="chosenOption", nullable = false)
    private Float chosenOption;

    @Column(name="rewarded")
    private Boolean rewarded;

    @Column(name="finished")
    private Boolean finished;

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

    public Boolean getRewarded() {
        return rewarded;
    }

    public void setRewarded(Boolean rewarded) {
        this.rewarded = rewarded;
    }

    public Float getChosenOption() {
        return chosenOption;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    public void setChosenOption(Float chosenOption) {
        this.chosenOption = chosenOption;
    }

    // Default constructor without any arguments
    public UserBet() {
    }

    public UserBet(Long id) {
        this.id = id;
    }

    public UserBet(Long userId, Long gameBetTo, Float amount, Float chosenOption) {
        this.userId = userId;
        this.gameBetTo = gameBetTo;
        this.amount = amount;
        this.chosenOption = chosenOption;
        this.rewarded = false;
        this.finished = false;
    }
}