package com.gridbetjavaa.gridbetjavaa.model;

import jakarta.persistence.*;

@Entity
@Table(name = "gamebet")
public class GameBet {

    @Id
    private Long id;
    @Column(name = "gameId", nullable = false)
    private Long gameId;
    @Column(name = "email", nullable = false)
    private String name;
    @Column(name="round")
    private Float round;

    @Column(name="team1name", nullable = false)
    private String team1name;

    @Column(name="team1amount")
    private Float team1amount;

    @Column(name="team2name", nullable = false)
    private String team2name;

    @Column(name="team2amount")
    private Float team2amount;

    @Column(name="totalAmount")
    private Float totalAmount;

    @Column(name="startDateTimestamp", nullable = false)
    private Float startDateTimestamp;

    @Column(name="endDateTimestamp", nullable = false)
    private Float endDateTimestamp;

    @Column(name="winner")
    private Float winner;

    @Column(name="odd")
    private Float odd;

    public Float getOdd() {
        return odd;
    }

    public void setOdd(Float odd) {
        this.odd = odd;
    }

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

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    // Default constructor without any arguments
    public GameBet() {
    }

    public GameBet(Long id) {
        this.id = id;
    }

    public GameBet(String name, Float round, String team1name, String team2name, Float startDateTimestamp, Float endDateTimestamp, Long gameId) {
        this.name = name;
        this.round = round;
        this.team1name = team1name;
        this.team2name = team2name;
        this.startDateTimestamp = startDateTimestamp;
        this.endDateTimestamp = endDateTimestamp;
        this.gameId = gameId;
        this.team1amount = 0F;
        this.team2amount = 0F;
        this.totalAmount = 0F;
        this.odd = 0F;
        Long roundLong = round.longValue();
        //unique id based on gameid + round + gameid
        Long id = Long.parseLong(gameId.toString() + roundLong.toString() + gameId.toString());
        this.id = id;
    }
}