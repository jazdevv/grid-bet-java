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
    GameBetRepository gameBetRepository;

    @Autowired
    UserBetService userBetService;
    public GameBet createBetGame(GameBet newGameBet){
        return gameBetRepository.save(newGameBet);
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
