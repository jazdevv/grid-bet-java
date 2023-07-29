package com.gridbetjavaa.gridbetjavaa.payload.Requests;

public class SetWinnerGameBetRequest {
    private Long gameId;
    private Float winnerIndex;

    private String jwtBet;


    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Float getWinnerIndex() {
        return winnerIndex;
    }

    public void setWinnerIndex(Float winnerIndex) {
        this.winnerIndex = winnerIndex;
    }

    public String getJwtBet() {
        return jwtBet;
    }

    public void setJwtBet(String jwtBet) {
        this.jwtBet = jwtBet;
    }
}
