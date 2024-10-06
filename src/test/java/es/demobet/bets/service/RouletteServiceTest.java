package es.demobet.bets.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import es.demobet.bets.model.dto.RouletteNumberDto;
import es.demobet.bets.service.impl.RouletteServiceImpl;

@SpringBootTest
public class RouletteServiceTest {
	
	@Test
	void getRouletteNumber() {
		RouletteService rouletteService = new RouletteServiceImpl();
		RouletteNumberDto rouletteNumberDto = rouletteService.generateRouletteNumber();
		
		assertTrue(rouletteNumberDto.getNumber() >= 0);
		assertTrue(rouletteNumberDto.getNumber() <= 36);
	}
	
}
