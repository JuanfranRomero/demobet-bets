package es.demobet.bets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.demobet.bets.model.dto.request.BetRequest;
import es.demobet.bets.model.dto.response.BetResponse;
import es.demobet.bets.model.dto.response.ProfitResponse;
import es.demobet.bets.model.entity.Bet;
import es.demobet.bets.service.BetService;

@RestController
@RequestMapping("/bets")
public class BetController {

	private final BetService betService;

	@Autowired
	public BetController(BetService betService) {
		this.betService = betService;
	}
	
	@PostMapping
	public ResponseEntity<BetResponse> bet(@RequestBody BetRequest betRequest) {
		BetResponse betResponse = betService.bet(betRequest);
		return ResponseEntity.ok(betResponse);
	}
	
	@GetMapping("/profit/{userId}/{gameId}")
	public ResponseEntity<ProfitResponse> checkProfit(@PathVariable Integer userId, @PathVariable Integer gameId) {
		return ResponseEntity.ok(betService.checkProfit(userId, gameId));
	}
	
	@GetMapping("/{userId}/{gameId}")
	public ResponseEntity<List<Bet>> getBetsInGame(@PathVariable Integer userId, @PathVariable Integer gameId) {
		return ResponseEntity.ok(betService.getBetsInGame(userId, gameId));
	}
	
}
