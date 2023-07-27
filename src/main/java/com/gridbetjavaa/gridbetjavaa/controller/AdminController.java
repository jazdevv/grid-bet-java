package com.gridbetjavaa.gridbetjavaa.controller;


import com.gridbetjavaa.gridbetjavaa.auth.AuthorizeUser;
import com.gridbetjavaa.gridbetjavaa.model.Game;
import com.gridbetjavaa.gridbetjavaa.model.GameBet;
import com.gridbetjavaa.gridbetjavaa.payload.Requests.NewGameBetRequest;
import com.gridbetjavaa.gridbetjavaa.payload.Requests.NewGameRequest;
import com.gridbetjavaa.gridbetjavaa.payload.Requests.SetWinnerGameBetRequest;
import com.gridbetjavaa.gridbetjavaa.payload.Requests.StartBetRequest;
import com.gridbetjavaa.gridbetjavaa.service.GameBetService;
import com.gridbetjavaa.gridbetjavaa.service.GameService;
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
    @Autowired
    private GameService gameService;
    @Autowired
    private GameBetService gameBetService;

    public AdminController(){
        jwtUtil = new JwtUtil();
    }
    @PostMapping("/newGame")
    @AuthorizeUser
    public ResponseEntity newGame(@CookieValue("jwtbet") String jwt, @RequestBody NewGameRequest req){
        restrictToAdmins(jwt);
        Game createdGame = gameService.createGame(req.getId(), req.getName());
        if(createdGame!=null){
            return ResponseEntity.ok().body("succes");
        }else{
            return ResponseEntity.ok().body("fail");
        }

    }

    @PostMapping("/newGameBet")
    @AuthorizeUser
    public ResponseEntity newGameBet(@CookieValue("jwtbet") String jwt, @RequestBody NewGameBetRequest req){
        restrictToAdmins(jwt);
        GameBet newGameBet = gameBetService.createBetGame(req.getName(), req.getRound(), req.getTeam1name(), req.getTeam2name(), req.getStartDateTimestamp(), req.getEndDateTimestamp(), req.getGameId());
        if(newGameBet!=null){
            return ResponseEntity.ok().body("succes");
        }else{
            return ResponseEntity.ok().body("fail");
        }

    }

    @PostMapping("/setWinnerGameBet")
    @AuthorizeUser
    public ResponseEntity setWinnerGameBet(@CookieValue("jwtbet") String jwt, @RequestBody SetWinnerGameBetRequest req){
        restrictToAdmins(jwt);
        GameBet gameBet = gameBetService.setGameWinner(req.getGameId(), req.getWinnerIndex());
        if(gameBet!=null){
            return ResponseEntity.ok().body("succes");
        }else{
            return ResponseEntity.ok().body("fail");
        }

    }

    private void restrictToAdmins(String jwt){
        Long userid = jwtUtil.extractUserId(jwt);
        if(userid!=1){
            throw new AccessDeniedException("access denied");
        }
    }
}
