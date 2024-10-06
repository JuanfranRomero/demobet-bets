package es.demobet.bets.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import es.demobet.bets.model.entity.Bet;
import es.demobet.bets.service.BetService;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class BetControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private BetService betService;
	
    @Test
    void getBetsInGame() throws Exception {
        List<Bet> bets  = new ArrayList<Bet>();
        bets.add(new Bet(1, 1, 1, "number", "20", 3));
        bets.add(new Bet(2, 1, 1, "number", "10", 10));
        when(betService.getBetsInGame(any(), any())).thenReturn(bets);

        mockMvc
        	.perform(get("/bets/1/1").contentType(MediaType.APPLICATION_JSON))
        	.andExpect(jsonPath("$", Matchers.hasSize(2)))
        	.andDo(print());
    }
    
}
