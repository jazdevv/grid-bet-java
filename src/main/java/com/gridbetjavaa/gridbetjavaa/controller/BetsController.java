package com.gridbetjavaa.gridbetjavaa.controller;

import com.gridbetjavaa.gridbetjavaa.auth.AuthorizeUser;
import com.gridbetjavaa.gridbetjavaa.model.Game;
import com.gridbetjavaa.gridbetjavaa.model.GameBet;
import com.gridbetjavaa.gridbetjavaa.model.UserBet;
import com.gridbetjavaa.gridbetjavaa.payload.Requests.StartBetRequest;
import com.gridbetjavaa.gridbetjavaa.service.GameBetService;
import com.gridbetjavaa.gridbetjavaa.service.GameService;
import com.gridbetjavaa.gridbetjavaa.service.UserBetService;
import com.gridbetjavaa.gridbetjavaa.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bets")
public class BetsController {
    private JwtUtil jwtUtil;
    @Autowired
    private UserBetService userBetService;

    @Autowired
    private GameBetService gameBetService;

    @Autowired
    private GameService gameService;

    public BetsController(){
        jwtUtil = new JwtUtil();
    }
    @PostMapping("/startBet")
    public ResponseEntity startBet(@RequestBody StartBetRequest req){
        Long userid = jwtUtil.authorize(req.getJwtBet());
        //update gameBetAmounts
        gameBetService.increaseAmount(req.getGameBetId(),req.getChoosenOption(),req.getAmount());
        //create userBet
        UserBet userBet = userBetService.startBet(userid,req.getGameBetId(),req.getAmount(),req.getChoosenOption());

        if(userBet!=null){
            return ResponseEntity.ok().body("succes");
        }else{
            return ResponseEntity.ok().body("fail");
        }


    }

    @GetMapping("/getgames")
    public List<Game> getGamesForBet(){
        return gameService.getGames();
    }
}
