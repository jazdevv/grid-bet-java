package com.gridbetjavaa.gridbetjavaa.controller;


import com.gridbetjavaa.gridbetjavaa.auth.AuthorizeUser;
import com.gridbetjavaa.gridbetjavaa.payload.Requests.StartBetRequest;
import com.gridbetjavaa.gridbetjavaa.service.UserBetService;
import com.gridbetjavaa.gridbetjavaa.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.*;

//used my other microservice or script to set new available games, gamebets, gamewinners,...

@RestController
@RequestMapping("/admin")
public class AdminController {

    private JwtUtil jwtUtil;

    public AdminController(){
        jwtUtil = new JwtUtil();
    }
    @PostMapping("/newGame")
    @AuthorizeUser
    public ResponseEntity newGame(@CookieValue("jwtbet") String jwt){
        restrictToAdmins(jwt);


        return ResponseEntity.ok().body("succes");

    }

    @PostMapping("/newGameBet")
    @AuthorizeUser
    public ResponseEntity newGameBet(@CookieValue("jwtbet") String jwt){
        restrictToAdmins(jwt);


        return ResponseEntity.ok().body("succes");

    }

    @PostMapping("/setWinnerGameBet")
    @AuthorizeUser
    public ResponseEntity setWinnerGameBet(@CookieValue("jwtbet") String jwt){
        restrictToAdmins(jwt);


        return ResponseEntity.ok().body("succes");

    }

    private void restrictToAdmins(String jwt){
        Long userid = jwtUtil.extractUserId(jwt);
        if(userid!=1){
            throw new AccessDeniedException("access denied");
        }
    }
}
