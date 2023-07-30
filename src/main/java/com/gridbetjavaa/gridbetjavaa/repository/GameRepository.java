package com.gridbetjavaa.gridbetjavaa.repository;

import com.gridbetjavaa.gridbetjavaa.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends JpaRepository<Game,Long> {
}
