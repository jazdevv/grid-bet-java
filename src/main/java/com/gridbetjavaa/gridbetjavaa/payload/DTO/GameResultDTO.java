package com.gridbetjavaa.gridbetjavaa.payload.DTO;

public class GameResultDTO {
    private Long gameBetId;
    private Float winnerOptionIndex;
    private Float odd;

    public Long getGameBetId() {
        return gameBetId;
    }

    public void setGameBetId(Long gameBetId) {
        this.gameBetId = gameBetId;
    }

    public Float getWinnerOptionIndex() {
        return winnerOptionIndex;
    }

    public void setWinnerOptionIndex(Float winnerOptionIndex) {
        this.winnerOptionIndex = winnerOptionIndex;
    }

    public Float getOdd() {
        return odd;
    }

    public void setOdd(Float odd) {
        this.odd = odd;
    }

    public GameResultDTO(Long gameBetId, Float winnerOptionIndex, Float odd) {
        this.gameBetId = gameBetId;
        this.winnerOptionIndex = winnerOptionIndex;
        this.odd = odd;
    }
}
