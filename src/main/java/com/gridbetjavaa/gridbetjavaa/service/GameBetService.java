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
            // Handle the case when the entity with the provided ID doesn't exist
            return null;
        }

    }


}
