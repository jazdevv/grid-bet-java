package com.gridbetjavaa.gridbetjavaa.payload.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class UserBetGet {
    private Float amount;
    private Long gameBetTo;
    private Boolean rewarded;
    private Boolean finished;
    private Float chosenOption;
    private Long id;
    private String team1name;

    private String team2name;

    private Float odd;

    public Float getOdd() {
        return odd;
    }

    public void setOdd(Float odd) {
        this.odd = odd;
    }

    public String getTeam1name() {
        return team1name;
    }

    public void setTeam1name(String team1name) {
        this.team1name = team1name;
    }

    public String getTeam2name() {
        return team2name;
    }

    public void setTeam2name(String team2name) {
        this.team2name = team2name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    public UserBetGet() {
    }

    public UserBetGet(Long id) {
        this.id = id;
    }

    public UserBetGet(Float amount,Long gameBetTo, Boolean rewarded, Boolean finished, Float chosenOption,Long id, String team1name, String team2name, Float odd) {
        this.id = id;
        this.gameBetTo = gameBetTo;
        this.amount = amount;
        this.chosenOption = chosenOption;
        this.rewarded = rewarded;
        this.finished = finished;
        this.team1name = team1name;
        this.team2name = team2name;
        this.odd = odd;
    }
}
