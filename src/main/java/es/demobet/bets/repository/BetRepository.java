package es.demobet.bets.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.demobet.bets.model.entity.Bet;

@Repository
public interface BetRepository extends JpaRepository<Bet, Integer> {

	public List<Bet> findByUserIdextAndGameId(@Param("userIdext") Integer userIdext, @Param("gameId") Integer gameId);

}
