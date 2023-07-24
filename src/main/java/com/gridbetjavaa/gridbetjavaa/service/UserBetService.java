package com.gridbetjavaa.gridbetjavaa.service;

import com.gridbetjavaa.gridbetjavaa.model.GameBet;
import com.gridbetjavaa.gridbetjavaa.model.UserBet;
import com.gridbetjavaa.gridbetjavaa.repository.UserBetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBetService {
    @Autowired
   private UserBetRepository userBetRepository;

    @Autowired
    private UserService userService;

    public UserBet startBet(Long userId, Long gameBetTo, Float amount, Float chosenOption){
        return userBetRepository.save(new UserBet( userId, gameBetTo, amount, chosenOption));
    }
    public void distributeRewards(GameBet gameBet){
        Float winnerOption = gameBet.getWinner();
        //get bets of that game
        List<UserBet> bets = userBetRepository.findByGameBetTo(gameBet.getGameId());
        //reward each game
        for(UserBet bet : bets){
            if(bet.getChosenOption().equals(winnerOption)){
                setAsWinner(bet);
            }else{
                setAsLoser(bet);
            }
        }
    }

    private void setAsWinner(UserBet userBet){
        //check userbet has not been finished
        if(userBet.getFinished()==false){
            //update the sql field
            userBet.setRewarded(true);
            userBet.setFinished(true);
            userBetRepository.save(userBet);
            userService.incrementUserCredit(userBet.getUserId(),userBet.getAmount());
        }

    }

    private void setAsLoser(UserBet userBet){
        //check userbet has not been finished
        if(userBet.getFinished()==false){
            //update the sql field
            userBet.setFinished(true);
            userBetRepository.save(userBet);
        }
    }
}