package com.gridbetjavaa.gridbetjavaa.service;

import com.gridbetjavaa.gridbetjavaa.model.Game;
import com.gridbetjavaa.gridbetjavaa.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameService {
    @Autowired
    GameRepository gameRepository;

    public Game createGame(Game game){
        return gameRepository.save(game);
    }

    public Game getGameById(Long id){
        Game game =  gameRepository.findById(id).orElse(null);;
        return game;
    }
}
