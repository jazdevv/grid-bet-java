package com.gridbetjavaa.gridbetjavaa.repository;


import com.gridbetjavaa.gridbetjavaa.model.UserBet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserBetRepository extends CrudRepository<UserBet,Long> {
    List<UserBet> findByUserId(Long userId);
    List<UserBet> findByGameBetTo(Long gameBetTo);
}
