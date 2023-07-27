package com.gridbetjavaa.gridbetjavaa.service;

import com.gridbetjavaa.gridbetjavaa.model.GameBet;
import com.gridbetjavaa.gridbetjavaa.model.UserBet;
import com.gridbetjavaa.gridbetjavaa.repository.UserBetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.List;

@Service
public class UserBetService {
    @Autowired
   private UserBetRepository userBetRepository;

    @Autowired
    private UserService userService;
    private GameBetService gameBetService;

    public UserBet startBet(Long userId, Long gameBetTo, Float amount, Float chosenOption){
        //ACTIVE AT PRODUCTION
        //restrict to closed bets
//        GameBet gamebet = gameBetService.getBetGame(gameBetTo);
//        if(gamebet.getEndDateTimestamp() > Instant.now().getEpochSecond()) {
//            return null;
//        };

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
            //get game bet
            GameBet gameBet = gameBetService.getBetGame(userBet.getGameBetTo());
            //update the sql field
            userBet.setRewarded(true);
            userBet.setFinished(true);
            userBetRepository.save(userBet);
            //calculate won amount
            Float returnRate;
            if(userBet.getChosenOption() == 1){
                returnRate = gameBet.getTotalAmount() / gameBet.getTeam1amount();
            }else{
                returnRate = gameBet.getTotalAmount() / gameBet.getTeam2amount();
            }
            System.out.println("return rate"+returnRate);
            Float wonAmount = userBet.getAmount() * returnRate;
            userService.incrementUserCredit(userBet.getUserId(), wonAmount);
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
