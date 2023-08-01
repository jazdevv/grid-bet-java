package com.gridbetjavaa.gridbetjavaa.service;

import com.gridbetjavaa.gridbetjavaa.model.Game;
import com.gridbetjavaa.gridbetjavaa.model.GameBet;
import com.gridbetjavaa.gridbetjavaa.payload.DTO.GameBetDTO;
import com.gridbetjavaa.gridbetjavaa.payload.DTO.GameResultDTO;
import com.gridbetjavaa.gridbetjavaa.repository.GameBetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameBetService {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private GameBetRepository gameBetRepository;

    @Autowired
    private UserBetService userBetService;
    public GameBet createBetGame(String name, Float round, String team1name, String team2name, Float startDateTimestamp, Float endDateTimestamp, Long gameId){
        //create and store to db the new game
        GameBet createdGame = gameBetRepository.save(new GameBet(name, round, team1name, team2name, startDateTimestamp, endDateTimestamp, gameId));
        //send message through the websocket to connected users
        simpMessagingTemplate.convertAndSend("/topic/bets",new GameBetDTO(createdGame.getGameId(), createdGame.getId(), createdGame.getTeam1name(), createdGame.getTeam2name(), createdGame.getRound()));

        return createdGame;
    }

    public GameBet getBetGame(Long id){
        return gameBetRepository.findById(id).orElse(null);
    }


    public GameBet setGameWinner(Long gameBetId, Float winner){
        GameBet gameBet = gameBetRepository.findById(gameBetId).orElse(null);

        if (gameBet != null) {
            //update the game bet
            gameBet.setWinner(winner);
            GameBet updatedGameBet = gameBetRepository.save(gameBet);
            //distribute rewards for that finished game
            userBetService.distributeRewards(updatedGameBet);
            //calculate odd winning rate to be sent to winners
            //calculate won amount
            Float oddsRate;
            System.out.println(updatedGameBet.getTotalAmount() + " " + updatedGameBet.getTeam1amount() + " " +updatedGameBet.getTeam2amount());
            if(updatedGameBet.getWinner() == 1){
                oddsRate = updatedGameBet.getTotalAmount() / updatedGameBet.getTeam1amount();
                System.out.println(oddsRate);
            }else{
                oddsRate = updatedGameBet.getTotalAmount() / updatedGameBet.getTeam2amount();
            }
            System.out.println(updatedGameBet.getTotalAmount() / updatedGameBet.getTeam1amount());
            System.out.println(oddsRate);
            //send to the websocket the bet results
            simpMessagingTemplate.convertAndSend("/topic/betsWins",new GameResultDTO(updatedGameBet.getId(), updatedGameBet.getWinner(), oddsRate));

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
