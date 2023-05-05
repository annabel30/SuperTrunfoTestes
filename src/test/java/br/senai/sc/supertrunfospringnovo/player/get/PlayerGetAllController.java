package br.senai.sc.supertrunfospringnovo.player.get;

import br.senai.sc.supertrunfospringnovo.controller.PlayerController;
import br.senai.sc.supertrunfospringnovo.model.entity.Player;
import br.senai.sc.supertrunfospringnovo.service.PlayerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasItems;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PlayerController.class)
public class PlayerGetAllController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlayerService repository;

    @Test
    public void getAll_shouldReturnUserList() throws Exception {

        List<Player> listPlayers;
        Player player1 = new Player(1, "Annabel", 18, 'F', "Sumeru", "Hydro", "Sword", 123, 0, 0);
        Player player2 = new Player(2, "Ana", 18, 'F', "Liyue", "Electro", "Sword", 123, 0, 0);
        Player player3 = new Player(3, "Caio", 19, 'M', "Sumeru", "Pyro", "Sword", 123, 0, 0);

        listPlayers = List.of(player1, player2, player3);

        when(repository.readAll())
                .thenReturn(listPlayers);

        mockMvc.perform(get("/player/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].idPlayer", hasItems(1, 2, 3)))
                .andExpect(jsonPath("$[*].name", hasItems("Annabel", "Ana", "Caio")))
                .andExpect(jsonPath("$[*].age", hasItems(18, 18, 19)))
                .andExpect(jsonPath("$[*].gender", hasItems("F", "F", "M")))
                .andExpect(jsonPath("$[*].region", hasItems("Sumeru", "Liyue", "Sumeru")))
                .andExpect(jsonPath("$[*].element", hasItems("Hydro", "Electro", "Pyro")))
                .andExpect(jsonPath("$[*].weapon", hasItems("Sword", "Sword", "Sword")))
                .andExpect(jsonPath("$[*].password", hasItems(123, 123, 123)))
                .andExpect(jsonPath("$[*].victories", hasItems(0, 0, 0)))
                .andExpect(jsonPath("$[*].defeats", hasItems(0, 0, 0)));
    }
}
