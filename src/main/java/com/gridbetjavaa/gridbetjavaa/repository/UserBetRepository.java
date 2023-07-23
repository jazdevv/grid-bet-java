package com.gridbetjavaa.gridbetjavaa.repository;


import com.gridbetjavaa.gridbetjavaa.model.UserBet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserBetRepository extends JpaRepository<UserBet,Long> {
    public List<UserBet> getUserBets(Long userId);
}
