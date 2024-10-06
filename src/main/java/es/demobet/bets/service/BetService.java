package es.demobet.bets.service;

import java.util.List;

import es.demobet.bets.model.dto.request.BetRequest;
import es.demobet.bets.model.dto.response.BetResponse;
import es.demobet.bets.model.dto.response.ProfitResponse;
import es.demobet.bets.model.entity.Bet;

public interface BetService {
	
	public BetResponse bet(BetRequest betRequest);
	
	public ProfitResponse checkProfit(Integer userIdext, Integer gameId);
	
	public List<Bet> getBetsInGame(Integer userIdext, Integer gameId);

}
