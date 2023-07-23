package com.gridbetjavaa.gridbetjavaa.repository;

import com.gridbetjavaa.gridbetjavaa.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game,Long> {
}
