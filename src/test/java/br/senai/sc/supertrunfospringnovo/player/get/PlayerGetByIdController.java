package br.senai.sc.supertrunfospringnovo.player.get;

import br.senai.sc.supertrunfospringnovo.controller.PlayerController;
import br.senai.sc.supertrunfospringnovo.model.entity.Player;
import br.senai.sc.supertrunfospringnovo.service.PlayerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PlayerController.class)
public class PlayerGetByIdController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlayerService repository;

    @Test
    public void getById_shouldReturnUser() throws Exception {
        Integer idPlayer = 1;
        Player player = new Player(1, "Annabel", 18, 'F', "Sumeru", "Hydro", "Sword", 123, 0, 0);

        when(repository.readSpecific(1))
                .thenReturn(player);

        mockMvc.perform(get("/player/specific/{id}", idPlayer)
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(player));
    }
}