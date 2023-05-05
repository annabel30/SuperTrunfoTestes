package br.senai.sc.supertrunfospringnovo.card.delete;

import br.senai.sc.supertrunfospringnovo.controller.CardController;
import br.senai.sc.supertrunfospringnovo.model.DTO.CardDTO;
import br.senai.sc.supertrunfospringnovo.model.entity.Card;
import br.senai.sc.supertrunfospringnovo.model.enums.*;
import br.senai.sc.supertrunfospringnovo.service.CardService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CardController.class)
public class CardDeleteController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CardService cardService;

    @Test
    public void deleteCardControllerTest() throws Exception {

        CardDTO cardDTO = new CardDTO("Kazuha", 1000, 60, 150, 700, 200, Element.Anemo, Region.Inazuma);
        Card card = new Card();
        BeanUtils.copyProperties(cardDTO, card);

        mockMvc.perform(delete("/card/delete/1"))
                .andExpect(status().isOk());
    }
}
