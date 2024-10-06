package es.demobet.bets.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RouletteNumberDto {

	private Integer number;
	private String color;
	private String column;
	private String row;
	private String half;
	private String parity;
	
}
