package es.demobet.bets.model.builder;

import es.demobet.bets.model.entity.Bet;

public class BetBuilder implements Builder<Bet> {
	
	private Integer id;
	private Integer gameId;
	private Integer userIdext;
	private String boxType;
	private String boxValue;
	private Integer amount;
	
	public BetBuilder withId(Integer id) {
		this.id = id;
		return this;
	}
	
	public BetBuilder withGameId(Integer gameId) {
		this.gameId = gameId;
		return this;
	}
	
	public BetBuilder withUserIdext(Integer userIdext) {
		this.userIdext = userIdext;
		return this;
	}
	
	public BetBuilder withBoxType(String boxType) {
		this.boxType = boxType;
		return this;
	}
	
	public BetBuilder withBoxValue(String boxValue) {
		this.boxValue = boxValue;
		return this;
	}
	
	public BetBuilder withAmount(Integer amount) {
		this.amount = amount;
		return this;
	}

	@Override
	public Bet build() {
		Bet bet = new Bet(this.id, this.gameId, this.userIdext, this.boxType, this.boxValue, this.amount);
		return bet;
	}
	
}
