package br.senai.sc.supertrunfospringnovo.player.delete;

import br.senai.sc.supertrunfospringnovo.controller.PlayerController;
import br.senai.sc.supertrunfospringnovo.model.DTO.PlayerDTO;
import br.senai.sc.supertrunfospringnovo.model.entity.Player;
import br.senai.sc.supertrunfospringnovo.service.PlayerService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PlayerController.class)
public class PlayerDeleteController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlayerService playerService;

    @Test
    public void deletePlayerControllerTest() throws Exception {

        PlayerDTO playerDTO = new PlayerDTO("Annabel", 18, 'F', "Sumeru", "Hydro", "Sword", 123);
        Player player = new Player();
        BeanUtils.copyProperties(playerDTO, player);

        mockMvc.perform(delete("/player/delete/1"))
                .andExpect(status().isOk());
    }
}
