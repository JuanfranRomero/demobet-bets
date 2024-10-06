package es.demobet.bets.service.impl;

import org.springframework.stereotype.Service;

import es.demobet.bets.model.builder.RouletteNumberDtoBuilder;
import es.demobet.bets.model.dto.RouletteNumberDto;
import es.demobet.bets.service.RouletteService;
import es.demobet.bets.utils.BoxConstants;

@Service
public class RouletteServiceImpl implements RouletteService {

	@Override
	public RouletteNumberDto generateRouletteNumber() {
		Integer rouletteNumber = (int) (Math.random() * 36);
		RouletteNumberDtoBuilder rouletteNumberDtoBuilder = new RouletteNumberDtoBuilder(rouletteNumber);
		
		if (rouletteNumber == 0) {
			return rouletteNumberDtoBuilder.build();
		}
		
		return rouletteNumberDtoBuilder
			.withColor(getColor(rouletteNumber))
			.withColumn(getColumn(rouletteNumber))
			.withRow(getRow(rouletteNumber))
			.withHalf(getHalf(rouletteNumber))
			.withParity(getParity(rouletteNumber))
			.build();
	}
	
	private String getColor(Integer number) {
		return BoxConstants.colorMap.get("Red").contains(number) ? "Red" : "Black";
	}
	
	private String getColumn(Integer number) {
		if (BoxConstants.columnMap.get("1st12").contains(number)) {
			return "1st12";
		} else if (BoxConstants.columnMap.get("2nd12").contains(number)) {
			return "2nd12";
		} else {
			return "3rd12";
		}
	}
	
	private String getRow(Integer number) {
		if (BoxConstants.rowMap.get("3-36").contains(number)) {
			return "3-36";
		} else if (BoxConstants.rowMap.get("2-35").contains(number)) {
			return "2-35";
		} else {
			return "1-34";
		}
	}
	
	private String getHalf(Integer number) {
		return BoxConstants.halfMap.get("1-18").contains(number) ? "1-18" : "19-36";
	}
	
	private String getParity(Integer number) {
		return BoxConstants.parityMap.get("Even").contains(number) ? "Even" : "Odd";
	}

}
