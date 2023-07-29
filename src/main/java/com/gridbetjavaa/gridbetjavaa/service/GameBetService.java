package com.gridbetjavaa.gridbetjavaa.service;

import com.gridbetjavaa.gridbetjavaa.model.Game;
import com.gridbetjavaa.gridbetjavaa.model.GameBet;
import com.gridbetjavaa.gridbetjavaa.repository.GameBetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameBetService {

    @Autowired
    private GameBetRepository gameBetRepository;

    @Autowired
    private UserBetService userBetService;
    public GameBet createBetGame(String name, Float round, String team1name, String team2name, Float startDateTimestamp, Float endDateTimestamp, Long gameId){

        return gameBetRepository.save(new GameBet(name, round, team1name, team2name, startDateTimestamp, endDateTimestamp, gameId));
    }

    public GameBet getBetGame(Long id){
        return gameBetRepository.findById(id).orElse(null);
    }

    public void emitGameBetToWebSocket(){

    }

    public GameBet setGameWinner(Long gameBetId, Float winner){
        GameBet gameBet = gameBetRepository.findById(gameBetId).orElse(null);

        if (gameBet != null) {
            //update the game bet
            gameBet.setWinner(winner);
            GameBet updatedGameBet = gameBetRepository.save(gameBet);
            //distribute rewards for that finished game
            userBetService.distributeRewards(updatedGameBet);

             return updatedGameBet;
        } else {
            System.out.println("game dont exists" + gameBetId);
            // Handle the case when the entity with the provided ID doesn't exist
            return null;
        }

    }

    public void increaseAmount(Long gameId, Float choosenOption, Float amount){
        //get the betgame
        GameBet gameBet = gameBetRepository.findById(gameId).orElse(null);

        //update the game amount
        if(choosenOption==1){
            gameBet.setTeam2amount(gameBet.getTeam2amount() + amount);

        }else{
            gameBet.setTeam1amount(gameBet.getTeam1amount() + amount);
        }
        gameBet.setTotalAmount(gameBet.getTotalAmount() + amount);
        gameBetRepository.save(gameBet);
    }


}
