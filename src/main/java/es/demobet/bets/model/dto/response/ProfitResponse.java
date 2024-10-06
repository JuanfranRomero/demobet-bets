package es.demobet.bets.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProfitResponse {

	private Integer profit;
	private Integer rouletteNumber;
	private Integer amount;
	
}
