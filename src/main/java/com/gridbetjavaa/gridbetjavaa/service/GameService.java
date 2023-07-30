package com.gridbetjavaa.gridbetjavaa.service;

import com.gridbetjavaa.gridbetjavaa.model.Game;
import com.gridbetjavaa.gridbetjavaa.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public Game createGame(Long id, String name){
        Game existinggame = gameRepository.findById(id).orElse(null);
        if(existinggame!=null){
            //game with that id exists so do not create again
            return null;
        }
        return gameRepository.save(new Game(name,id));
    }

    public Game getGameById(Long id){
        Game game =  gameRepository.findById(id).orElse(null);;
        return game;
    }

    public List<Game> getGames(){
        List<Game> games = gameRepository.findAll();
        return games;
    }
}
