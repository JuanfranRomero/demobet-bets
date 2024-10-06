package es.demobet.bets.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import es.demobet.bets.model.builder.BetBuilder;
import es.demobet.bets.model.entity.Bet;
import es.demobet.bets.repository.BetRepository;
import es.demobet.bets.repository.GameRepository;
import es.demobet.bets.service.impl.BetServiceImpl;

@SpringBootTest
public class BetServiceTest {

	@MockBean
	private BetRepository betRepository;
	
	@MockBean
	private GameRepository gameRepository;

	@Test
	void getBetsInGame() {
		BetBuilder betBuilder = new BetBuilder();
		Bet firstUserFirstGameBet = betBuilder
				.withId(1)
				.withGameId(1)
				.withUserIdext(1)
				.withBoxType("number")
				.withBoxValue("20")
				.withAmount(3)
				.build();
		
		Bet secondUserFirstGameBet = betBuilder
				.withId(2)
				.withGameId(1)
				.withUserIdext(2)
				.withBoxType("number")
				.withBoxValue("20")
				.withAmount(3)
				.build();
		
		Bet firstUserSecondGameBet = betBuilder
				.withId(3)
				.withGameId(2)
				.withUserIdext(1)
				.withBoxType("number")
				.withBoxValue("20")
				.withAmount(3)
				.build();
		
		
		Bet secondUserSecondGameBet = betBuilder
				.withId(4)
				.withGameId(2)
				.withUserIdext(2)
				.withBoxType("number")
				.withBoxValue("20")
				.withAmount(3)
				.build();
		
		betRepository.save(firstUserFirstGameBet);
		betRepository.save(secondUserFirstGameBet);
		betRepository.save(firstUserSecondGameBet);
		betRepository.save(secondUserSecondGameBet);
	    	    
	    when(betRepository.findByUserIdextAndGameId(1, 1)).thenReturn(List.of(firstUserFirstGameBet));
		
	    BetService betService = new BetServiceImpl(betRepository, gameRepository, null, null);
	    List<Bet> betList = betService.getBetsInGame(1, 1);
	    Bet firstUserFirstGameBetFromRealService = betList.get(0);

	    assertEquals(firstUserFirstGameBet.getId(), firstUserFirstGameBetFromRealService.getId());
	    assertEquals(firstUserFirstGameBet.getGameId(), firstUserFirstGameBetFromRealService.getGameId());
	    assertEquals(firstUserFirstGameBet.getUserIdext(), firstUserFirstGameBetFromRealService.getUserIdext());
	    assertEquals(firstUserFirstGameBet.getBoxType(), firstUserFirstGameBetFromRealService.getBoxType());
	    assertEquals(firstUserFirstGameBet.getBoxValue(), firstUserFirstGameBetFromRealService.getBoxValue());
	    assertEquals(firstUserFirstGameBet.getAmount(), firstUserFirstGameBetFromRealService.getAmount());
	}

}
