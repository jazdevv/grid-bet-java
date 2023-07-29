package com.gridbetjavaa.gridbetjavaa.payload.Requests;

public class StartBetRequest {
    private Long gameBetId;
    private Float amount;
    private Float choosenOption;

    private String jwtBet;

    public Long getGameBetId() {
        return gameBetId;
    }

    public void setGameBetId(Long gameBetId) {
        this.gameBetId = gameBetId;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Float getChoosenOption() {
        return choosenOption;
    }

    public void setChoosenOption(Float choosenOption) {
        this.choosenOption = choosenOption;
    }

    public String getJwtBet() {
        return jwtBet;
    }

    public void setJwtBet(String jwtBet) {
        this.jwtBet = jwtBet;
    }

    public StartBetRequest(Long gameBetId, Float amount, Float choosenOption, String jwtBet) {
        this.gameBetId = gameBetId;
        this.amount = amount;
        this.choosenOption = choosenOption;
        this.jwtBet = jwtBet;
    }
}
