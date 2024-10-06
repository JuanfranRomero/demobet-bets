package es.demobet.bets.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BetResponse {

	private Integer amount;
	
	private Integer gameId;
	
}
