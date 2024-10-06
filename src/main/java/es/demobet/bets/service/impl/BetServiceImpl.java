package es.demobet.bets.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import es.demobet.bets.model.builder.BetBuilder;
import es.demobet.bets.model.dto.RouletteNumberDto;
import es.demobet.bets.model.dto.request.BetRequest;
import es.demobet.bets.model.dto.request.external.WalletRequest;
import es.demobet.bets.model.dto.response.BetResponse;
import es.demobet.bets.model.dto.response.ProfitResponse;
import es.demobet.bets.model.dto.response.external.WalletResponse;
import es.demobet.bets.model.entity.Bet;
import es.demobet.bets.model.entity.Game;
import es.demobet.bets.repository.BetRepository;
import es.demobet.bets.repository.GameRepository;
import es.demobet.bets.service.BetService;
import es.demobet.bets.service.RouletteService;
import es.demobet.bets.utils.BoxConstants;
import es.demobet.bets.utils.EndpointConstants;

@Service
public class BetServiceImpl implements BetService {

	private final BetRepository betRepository;
	private final GameRepository gameRepository;
	private final RestTemplate restTemplate;
	private final RouletteService rouletteService;
	
	@Autowired
	public BetServiceImpl(BetRepository betRepository, GameRepository gameRepository, RestTemplate restTemplate, RouletteService rouletteService) {
		this.betRepository = betRepository;
		this.gameRepository = gameRepository;
		this.restTemplate = restTemplate;
		this.rouletteService = rouletteService;
	}
	
	@Override
	public BetResponse bet(BetRequest betRequest) {
		BetResponse betResponse = null;
		
		if (betRequest.getBets().isEmpty()) 
			return betResponse;
		
		LocalDateTime localDateTime = LocalDateTime.now();
		Game game = new Game();
		game.setDatetimeCreation(localDateTime);
		Game createdGame = gameRepository.save(game);
		
		if (createdGame != null) {
			Integer createdGameId = createdGame.getId();
			BetBuilder betBuilder = new BetBuilder();
			List<Bet> bets = betRequest.getBets()
				.entrySet()
				.stream()
				.map(bet -> 
					betBuilder
						.withUserIdext(betRequest.getUserId())
						.withGameId(createdGameId)
						.withBoxType(BoxConstants.boxTypesMap.get(bet.getKey()))
						.withBoxValue(bet.getKey())
						.withAmount(bet.getValue())
						.build())
				.collect(Collectors.toList());
			
			Integer wholeAmount = 0;
			for (Bet bet : bets) {
				wholeAmount += bet.getAmount();
				betRepository.save(bet);
			};
				
        	// Invoke wallet micro-service to subtract the whole amount
			WalletResponse walletResponse = invokeWalletMSToSubtract(betRequest.getUserId(), wholeAmount);
			
			if (walletResponse != null) {
				betResponse = new BetResponse(walletResponse.getAmount(), createdGame.getId());
			}
		}
		
		return betResponse;
	}
	
	@Override
	public ProfitResponse checkProfit(Integer userIdext, Integer gameId) {
		RouletteNumberDto rouletteNumberDto = rouletteService.generateRouletteNumber();
		
		List<Bet> bets = betRepository.findByUserIdextAndGameId(userIdext, gameId);
		Integer profit = calculateProfit(bets, rouletteNumberDto);
		
		ProfitResponse profitResponse = new ProfitResponse(profit, rouletteNumberDto.getNumber(), null);
		
		if (profit > 0) {
			// Invoke wallet micro-service to increase with profit
			WalletResponse walletResponse = invokeWalletMSToIncreaseProfit(userIdext, profit);
			
			if (walletResponse != null) {
				profitResponse.setAmount(walletResponse.getAmount());
			}
		}
    	
		return profitResponse;
	}

	@Override
	public List<Bet> getBetsInGame(Integer userIdext, Integer gameId) {
		return betRepository.findByUserIdextAndGameId(userIdext, gameId);
	}
	
	private Integer calculateProfit(List<Bet> bets, RouletteNumberDto rouletteNumberDto) {
		Integer profit = 0;
		for (Bet bet : bets) {
			switch (bet.getBoxType()) {
			case "color": {
				if (bet.getBoxValue().equalsIgnoreCase(rouletteNumberDto.getColor())) {
					profit += bet.getAmount() * 2;
				}
				break;
			}
			
			case "column":
				if (bet.getBoxValue().equalsIgnoreCase(rouletteNumberDto.getColumn())) {
					profit += bet.getAmount() * 3;
				}
				break;
			
			case "row":
				if (bet.getBoxValue().equalsIgnoreCase(rouletteNumberDto.getRow())) {
					profit += bet.getAmount() * 3;
				}
				break;
				
			case "half":
				if (bet.getBoxValue().equalsIgnoreCase(rouletteNumberDto.getHalf())) {
					profit += bet.getAmount() * 2;
				}
				break;
				
			case "parity":
				if (bet.getBoxValue().equalsIgnoreCase(rouletteNumberDto.getParity())) {
					profit += bet.getAmount() * 2;
				}
				break;

			// Number
			default:
				if (bet.getBoxValue().equalsIgnoreCase(rouletteNumberDto.getNumber().toString())) {
					profit += bet.getAmount() * 36;
				}
				break;
			}
		}
		
		return profit;
	}
	
	private WalletResponse invokeWalletMSToSubtract(Integer userId, Integer amount) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(EndpointConstants.WALLET_SUBTRACT_URL);
		
        WalletRequest walletRequest = new WalletRequest(userId, amount);
        HttpEntity<WalletRequest> httpEntity = new HttpEntity<WalletRequest>(walletRequest);

        ResponseEntity<WalletResponse> responseEntity = 
        		restTemplate.exchange(builder.toUriString(), HttpMethod.PUT, httpEntity, WalletResponse.class);
        
        return responseEntity.getBody();
	}
	
	private WalletResponse invokeWalletMSToIncreaseProfit(Integer userId, Integer amount) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(EndpointConstants.WALLET_INCREASE_PROFIT_URL);
		
        WalletRequest walletRequest = new WalletRequest(userId, amount);
        HttpEntity<WalletRequest> httpEntity = new HttpEntity<WalletRequest>(walletRequest);

        ResponseEntity<WalletResponse> responseEntity = 
        		restTemplate.exchange(builder.toUriString(), HttpMethod.PUT, httpEntity, WalletResponse.class);
        
        return responseEntity.getBody();
	}

}
