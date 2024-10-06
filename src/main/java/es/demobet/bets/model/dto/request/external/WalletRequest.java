package es.demobet.bets.model.dto.request.external;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class WalletRequest {

	private Integer userId;
	
	private Integer amount;
	
}
