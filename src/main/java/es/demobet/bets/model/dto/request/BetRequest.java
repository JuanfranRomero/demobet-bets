package es.demobet.bets.model.dto.request;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BetRequest {

	private Integer userId;
	private Map<String, Integer> bets;
	
}
