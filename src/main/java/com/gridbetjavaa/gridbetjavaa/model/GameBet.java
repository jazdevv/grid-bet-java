package com.gridbetjavaa.gridbetjavaa.model;

import jakarta.persistence.*;

@Entity
@Table(name = "gamebet")
public class GameBet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "email", nullable = false)
    private String name;
    @Column(name="round")
    private Float round;

    @Column(name="team1name")
    private String team1name;

    @Column(name="team1amount")
    private Float team1amount;

    @Column(name="team2name")
    private String team2name;

    @Column(name="team2amount")
    private Float team2amount;

    @Column(name="totalAmount")
    private Float totalAmount;

    @Column(name="startDateTimestamp")
    private Float startDateTimestamp;

    @Column(name="endDateTimestamp")
    private Float endDateTimestamp;

    @Column(name="winner")
    private Float winner;

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


    public Float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getTeam1name() {
        return team1name;
    }

    public void setTeam1name(String team1name) {
        this.team1name = team1name;
    }

    public Float getTeam1amount() {
        return team1amount;
    }

    public void setTeam1amount(Float team1amount) {
        this.team1amount = team1amount;
    }

    public String getTeam2name() {
        return team2name;
    }

    public void setTeam2name(String team2name) {
        this.team2name = team2name;
    }

    public Float getTeam2amount() {
        return team2amount;
    }

    public void setTeam2amount(Float team2amount) {
        this.team2amount = team2amount;
    }

    public Float getStartDateTimestamp() {
        return startDateTimestamp;
    }

    public void setStartDateTimestamp(Float startDateTimestamp) {
        this.startDateTimestamp = startDateTimestamp;
    }

    public Float getEndDateTimestamp() {
        return endDateTimestamp;
    }

    public void setEndDateTimestamp(Float endDateTimestamp) {
        this.endDateTimestamp = endDateTimestamp;
    }

    public Float getRound() {
        return round;
    }

    public void setRound(Float round) {
        this.round = round;
    }

    public Float getWinner() {
        return winner;
    }

    public void setWinner(Float winner) {
        this.winner = winner;
    }

    // Default constructor without any arguments
    public GameBet() {
    }

    public GameBet(Long id) {
        this.id = id;
    }
}