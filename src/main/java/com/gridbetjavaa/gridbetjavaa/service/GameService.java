package com.gridbetjavaa.gridbetjavaa.service;

import com.gridbetjavaa.gridbetjavaa.model.Game;
import com.gridbetjavaa.gridbetjavaa.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public Game createGame(Game game){
        Game existinggame = gameRepository.findById(game.getId()).orElse(null);
        if(existinggame==null){
            //game with that id exists so do not create again
            return null;
        }
        return gameRepository.save(game);
    }

    public Game getGameById(Long id){
        Game game =  gameRepository.findById(id).orElse(null);;
        return game;
    }
}
