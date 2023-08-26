package com.gridbetjavaa.gridbetjavaa.payload.Requests;

public class GetMyBetsRequest {
    private String jwtBet;

    public String getJwtBet() {
        return jwtBet;
    }

    public void setJwtBet(String jwtBet) {
        this.jwtBet = jwtBet;
    }
}
