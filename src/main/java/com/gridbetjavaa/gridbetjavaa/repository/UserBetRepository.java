package com.gridbetjavaa.gridbetjavaa.repository;


import com.gridbetjavaa.gridbetjavaa.model.UserBet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserBetRepository extends CrudRepository<UserBet,Long> {
    //?1 is the value user_id, anyways use in the value @Param("user_id") Long user_id and in the SQL query :user_id
    // instead of ?1 is possible
    @Query(
            value = "SELECT " +
                    "userbet.amount AS amount," +
                    "userbet.game_bet_to AS game_bet_to, " +
                    "userbet.rewarded AS rewarded," +
                    "userbet.finished AS finished, " +
                    "userbet.chosen_option AS chosen_option," +
                    "userbet.id AS id," +
                    "gamebet.team1name AS team1name," +
                    "gamebet.team2name AS team2name, " +
                    "gamebet.odd AS odd, " +
                    "gamebet.winner AS winner " +
                    "FROM userbet INNER JOIN gamebet ON userbet.game_bet_to = gamebet.id WHERE userbet.user_id=?1",
            nativeQuery = true
    )
    List<Object[]> findByUserId(Long user_id);
    List<UserBet> findByGameBetTo(Long gameBetTo);
}
