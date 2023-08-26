package com.gridbetjavaa.gridbetjavaa.service;

import com.gridbetjavaa.gridbetjavaa.model.GameBet;
import com.gridbetjavaa.gridbetjavaa.model.UserBet;
import com.gridbetjavaa.gridbetjavaa.payload.DTO.UserBetGet;
import com.gridbetjavaa.gridbetjavaa.repository.UserBetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserBetService {
    @Autowired
   private UserBetRepository userBetRepository;

    @Autowired
    private UserService userService;

    public UserBet startBet(Long userId, Long gameBetTo, Float amount, Float chosenOption){
        //ACTIVE AT PRODUCTION
        //restrict to closed bets
//        GameBet gamebet = gameBetService.getBetGame(gameBetTo);
//        if(gamebet.getEndDateTimestamp() > Instant.now().getEpochSecond()) {
//            return null;
//        };

        return userBetRepository.save(new UserBet( userId, gameBetTo, amount, chosenOption));
    }

    public List<UserBetGet> getUserBets(Long userId){
        List<Object[]> queryResult = userBetRepository.findByUserId(userId);
        List<UserBetGet> userBetList = new ArrayList<>();

        for (Object[] result : queryResult) {
            UserBetGet userBet = new UserBetGet(
                    (Float) result[0],    // amount
                    (Long) result[1],    // game_bet_to
                    (Boolean) result[2], // rewarded
                    (Boolean) result[3], // finished
                    (Float) result[4],   // chosen_option
                    (Long) result[5],    // id
                    (String) result[6],  // team1name
                    (String) result[7],   // team2name
                    (Float) result[8],
                    (Float) result[9]
            );
            userBetList.add(userBet);
        }
        return userBetList;
    }

    public void distributeRewards(GameBet gameBet){
        Float winnerOption = gameBet.getWinner();
        //get bets of that game
        List<UserBet> bets = userBetRepository.findByGameBetTo(gameBet.getId());
        //reward each game
        for(UserBet bet : bets){
            if(bet.getChosenOption().equals(winnerOption)){
                setAsWinner(bet,gameBet);
            }else{
                setAsLoser(bet);
            }
        }
    }
    private void setAsWinner(UserBet userBet, GameBet gameBet){
        //check userbet has not been finished
        if(userBet.getFinished()==false){
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
            Float wonAmount = userBet.getAmount() * returnRate;
            System.out.println("amount"+wonAmount);
            System.out.println("userid"+userBet.getUserId());
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
