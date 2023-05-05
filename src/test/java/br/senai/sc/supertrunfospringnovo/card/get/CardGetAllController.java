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

import java.util.List;

import static org.hamcrest.Matchers.hasItems;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CardController.class)
public class CardGetAllController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CardService repository;

    @Test
    public void getAll_shouldReturnCardListTest() throws Exception {

        List<Card> listCards;
        Card card1 = new Card(1, "Kazuha", 1000, 60, 150, 700, 200, Element.Anemo, Region.Inazuma, "http");
        Card card2 = new Card(2, "Raiden", 2000, 100, 280, 400, 280, Element.Electro, Region.Inazuma, "http");
        Card card3 = new Card(3, "Zhongli", 1500, 80, 200, 150, 100, Element.Geo, Region.Liyue, "http");

        listCards = List.of(card1, card2, card3);

        when(repository.readAll())
                .thenReturn(listCards);

        mockMvc.perform(get("/card/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].idCard", hasItems(1, 2, 3)))
                .andExpect(jsonPath("$[*].name", hasItems("Kazuha", "Raiden", "Zhongli")))
                .andExpect(jsonPath("$[*].atk", hasItems(1000, 2000, 1500)))
                .andExpect(jsonPath("$[*].criticalRate", hasItems(60, 100, 80)))
                .andExpect(jsonPath("$[*].criticalDamage", hasItems(150, 280, 200)))
                .andExpect(jsonPath("$[*].elementalMastery", hasItems(700, 400, 150)))
                .andExpect(jsonPath("$[*].energyRecharge", hasItems(200, 280, 100)))
                .andExpect(jsonPath("$[*].element", hasItems(Element.Anemo.toString(), Element.Electro.toString(), Element.Geo.toString())))
                .andExpect(jsonPath("$[*].region", hasItems(Region.Inazuma.toString(), Region.Inazuma.toString(), Region.Liyue.toString())))
                .andExpect(jsonPath("$[*].image", hasItems("http", "http", "http")));
    }
}
