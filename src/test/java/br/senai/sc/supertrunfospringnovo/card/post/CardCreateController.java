package br.senai.sc.supertrunfospringnovo.card.post;

import br.senai.sc.supertrunfospringnovo.controller.CardController;
import br.senai.sc.supertrunfospringnovo.model.DTO.CardDTO;
import br.senai.sc.supertrunfospringnovo.model.entity.Card;
import br.senai.sc.supertrunfospringnovo.model.enums.*;
import br.senai.sc.supertrunfospringnovo.service.CardService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CardController.class)
public class CardCreateController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CardService cardService;

    @Test
    public void createCardControllerTest() throws Exception {

        Integer idCard = 1;

        Card card = new Card(idCard, "Kazuha", 1000, 60, 150, 700, 200, Element.Anemo, Region.Inazuma, "http");
        CardDTO cardDTO = new CardDTO("Kazuha", 1000, 60, 150, 700, 200, Element.Anemo, Region.Inazuma);

        when(cardService.create(cardDTO)).thenReturn(card);

        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(card);

        mockMvc.perform(post("/card/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(card));
    }
}