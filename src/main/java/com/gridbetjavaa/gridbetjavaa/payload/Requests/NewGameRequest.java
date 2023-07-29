package com.gridbetjavaa.gridbetjavaa.payload.Requests;

import com.gridbetjavaa.gridbetjavaa.model.Game;

public class NewGameRequest extends Game {
    private String jwtBet;

    public String getJwtBet() {
        return jwtBet;
    }

    public void setJwtBet(String jwtBet) {
        this.jwtBet = jwtBet;
    }
}
