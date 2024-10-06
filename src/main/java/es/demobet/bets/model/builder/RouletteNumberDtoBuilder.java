package es.demobet.bets.model.builder;

import es.demobet.bets.model.dto.RouletteNumberDto;

public class RouletteNumberDtoBuilder implements Builder<RouletteNumberDto> {

	private Integer number;
	private String color;
	private String column;
	private String row;
	private String half;
	private String parity;
	
	public RouletteNumberDtoBuilder(Integer number) {
		this.number = number;
	}
	
	public RouletteNumberDtoBuilder withColor(String color) {
		this.color = color;
		return this;
	}
	
	public RouletteNumberDtoBuilder withColumn(String column) {
		this.column = column;
		return this;
	}
	
	public RouletteNumberDtoBuilder withRow(String row) {
		this.row = row;
		return this;
	}
	
	public RouletteNumberDtoBuilder withHalf(String half) {
		this.half = half;
		return this;
	}
	
	public RouletteNumberDtoBuilder withParity(String parity) {
		this.parity = parity;
		return this;
	}
	
	public RouletteNumberDto build() {
		RouletteNumberDto rouletteNumberDto = new RouletteNumberDto();
		rouletteNumberDto.setNumber(this.number);
		rouletteNumberDto.setColor(this.color);
		rouletteNumberDto.setColumn(this.column);
		rouletteNumberDto.setRow(this.row);
		rouletteNumberDto.setHalf(this.half);
		rouletteNumberDto.setParity(this.parity);
		
		return rouletteNumberDto;
	}
	
}
