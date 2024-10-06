package es.demobet.bets.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Bet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer id;
	
	@Column(name = "GAME_ID")
	private Integer gameId;
	
	@Column(name = "USER_IDEXT")
	private Integer userIdext;
	
	@Column(name = "BOX_TYPE")
	private String boxType;
	
	@Column(name = "BOX_VALUE")
	private String boxValue;
	
	private Integer amount;
	
	public Bet(Integer id, Integer gameId, Integer userIdext, String boxType, String boxValue, Integer amount) {
		this.id = id;
		this.gameId = gameId;
		this.userIdext = userIdext;
		this.boxType = boxType;
		this.boxValue = boxValue;
		this.amount = amount;
	}
	
}
