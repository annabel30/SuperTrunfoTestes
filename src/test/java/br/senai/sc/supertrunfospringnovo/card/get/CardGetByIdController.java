package br.senai.sc.supertrunfospringnovo.card.get;

import br.senai.sc.supertrunfospringnovo.controller.CardController;
import br.senai.sc.supertrunfospringnovo.model.entity.Card;
import br.senai.sc.supertrunfospringnovo.model.enums.*;
import br.senai.sc.supertrunfospringnovo.service.CardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CardController.class)
public class CardGetByIdController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CardService repository;

    @Test
    public void getById_shouldReturnUser() throws Exception {
        Integer idCard = 1;
        Card card = new Card(1, "Kazuha", 1000, 60, 150, 700, 200, Element.Anemo, Region.Inazuma, "http");

        when(repository.readSpecific(1))
                .thenReturn(card);

        mockMvc.perform(get("/card/specific/{id}", idCard)
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(card));
    }
}
