package es.demobet.bets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.demobet.bets.model.entity.Game;

public interface GameRepository extends JpaRepository<Game, Integer>{

}
