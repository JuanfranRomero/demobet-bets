package es.demobet.bets.service.impl;

import org.springframework.stereotype.Service;

import es.demobet.bets.model.builder.RouletteNumberDtoBuilder;
import es.demobet.bets.model.dto.RouletteNumberDto;
import es.demobet.bets.service.RouletteService;
import es.demobet.bets.utils.BoxConstants;
import es.demobet.bets.utils.enumeration.ColorEnum;
import es.demobet.bets.utils.enumeration.ColumnEnum;
import es.demobet.bets.utils.enumeration.HalfEnum;
import es.demobet.bets.utils.enumeration.ParityEnum;
import es.demobet.bets.utils.enumeration.RowEnum;

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
		return BoxConstants.colorMap.get(ColorEnum.RED.getValue()).contains(number) 
				? ColorEnum.RED.getValue() : ColorEnum.BLACK.getValue();
	}
	
	private String getColumn(Integer number) {
		if (BoxConstants.columnMap.get(ColumnEnum.FIRST_COLUMN.getValue()).contains(number)) {
			return ColumnEnum.FIRST_COLUMN.getValue();
		} else if (BoxConstants.columnMap.get(ColumnEnum.SECOND_COLUMN.getValue()).contains(number)) {
			return ColumnEnum.SECOND_COLUMN.getValue();
		} else {
			return ColumnEnum.THIRD_COLUMN.getValue();
		}
	}
	
	private String getRow(Integer number) {
		if (BoxConstants.rowMap.get(RowEnum.FIRST_ROW.getValue()).contains(number)) {
			return RowEnum.FIRST_ROW.getValue();
		} else if (BoxConstants.rowMap.get(RowEnum.SECOND_ROW.getValue()).contains(number)) {
			return RowEnum.SECOND_ROW.getValue();
		} else {
			return RowEnum.THIRD_ROW.getValue();
		}
	}
	
	private String getHalf(Integer number) {
		return BoxConstants.halfMap.get(HalfEnum.FIRST_HALF.getValue()).contains(number) 
				? HalfEnum.FIRST_HALF.getValue() : HalfEnum.SECOND_HALF.getValue();
	}
	
	private String getParity(Integer number) {
		return BoxConstants.parityMap.get(ParityEnum.EVEN.getValue()).contains(number) 
				? ParityEnum.EVEN.getValue() : ParityEnum.ODD.getValue();
	}

}
