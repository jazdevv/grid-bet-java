package com.gridbetjavaa.gridbetjavaa.controller;

import com.gridbetjavaa.gridbetjavaa.auth.AuthorizeUser;
import com.gridbetjavaa.gridbetjavaa.model.UserBet;
import com.gridbetjavaa.gridbetjavaa.payload.Requests.StartBetRequest;
import com.gridbetjavaa.gridbetjavaa.service.UserBetService;
import com.gridbetjavaa.gridbetjavaa.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bets")
public class BetsController {
    private JwtUtil jwtUtil;
    @Autowired
    private UserBetService userBetService;

    public BetsController(){
        jwtUtil = new JwtUtil();
    }
    @PostMapping("/startBet")
    @AuthorizeUser
    public ResponseEntity startBet(@CookieValue("jwtbet") String jwt, @RequestBody StartBetRequest req){
        Long userid = jwtUtil.extractUserId(jwt);
        System.out.println(userid + req.getGameBetId() + req.getAmount());
        UserBet userBet = userBetService.startBet(userid,req.getGameBetId(),req.getAmount(),req.getChoosenOption());
        if(userBet!=null){
            return ResponseEntity.ok().body("succes");
        }else{
            return ResponseEntity.ok().body("fail");
        }


    }
}
