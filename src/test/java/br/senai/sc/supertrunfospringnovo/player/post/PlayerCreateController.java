package br.senai.sc.supertrunfospringnovo.player.post;

import br.senai.sc.supertrunfospringnovo.controller.PlayerController;
import br.senai.sc.supertrunfospringnovo.model.DTO.PlayerDTO;
import br.senai.sc.supertrunfospringnovo.model.entity.Player;

import br.senai.sc.supertrunfospringnovo.service.PlayerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PlayerController.class)
public class PlayerCreateController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlayerService playerService;

    @Test
    public void createPlayerControllerTest() throws Exception {

        Integer idPlayer = 1;

        Player player = new Player(idPlayer, "Annabel", 18, 'F', "Sumeru", "Hydro", "Sword", 123, 0, 0);
        PlayerDTO playerDTO = new PlayerDTO("Annabel", 18, 'F', "Sumeru", "Hydro", "Sword", 123);

        when(playerService.create(playerDTO)).thenReturn(player);

        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(player);

        mockMvc.perform(post("/player/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(player));
    }
}
