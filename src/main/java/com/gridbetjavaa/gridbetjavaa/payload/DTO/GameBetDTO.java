package com.gridbetjavaa.gridbetjavaa.payload.DTO;

public class GameBetDTO {
    private Long gameId;
    private Long gameBetId;
    private String option0;
    private String option1;

    private Float round;

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Long getGameBetId() {
        return gameBetId;
    }

    public void setGameBetId(Long gameBetId) {
        this.gameBetId = gameBetId;
    }

    public String getOption0() {
        return option0;
    }

    public void setOption0(String option0) {
        this.option0 = option0;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public Float getRound() {
        return round;
    }

    public void setRound(Float round) {
        this.round = round;
    }



    public GameBetDTO(Long gameId, Long gameBetId, String option0, String option1, Float round) {
        this.gameId = gameId;
        this.gameBetId = gameBetId;
        this.option0 = option0;
        this.option1 = option1;
        this.round = round;
    }
}
