package com.gridbetjavaa.gridbetjavaa.payload.Requests;

public class NewGameBetRequest {
    private String name;
    private Float round;
    private String team1name;
    private String team2name;
    private Float startDateTimestamp;
    private Float endDateTimestamp;
    private Long gameId;

    private String jwtBet;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getRound() {
        return round;
    }

    public void setRound(Float round) {
        this.round = round;
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

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getJwtBet() {
        return jwtBet;
    }

    public void setJwtBet(String jwtBet) {
        this.jwtBet = jwtBet;
    }

    public NewGameBetRequest(String name, Float round, String team1name, String team2name, Float startDateTimestamp, Float endDateTimestamp, Long gameId, String jwtBet) {
        this.name = name;
        this.round = round;
        this.team1name = team1name;
        this.team2name = team2name;
        this.startDateTimestamp = startDateTimestamp;
        this.endDateTimestamp = endDateTimestamp;
        this.gameId = gameId;
        this.jwtBet = jwtBet;
    }
}
