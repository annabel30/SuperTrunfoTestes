package br.senai.sc.supertrunfospringnovo.service;

import br.senai.sc.supertrunfospringnovo.model.DTO.PlayerDTO;
import br.senai.sc.supertrunfospringnovo.model.entity.Player;
import br.senai.sc.supertrunfospringnovo.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PlayerService {

    private PlayerRepository playerRepository;

    public Player create(PlayerDTO playerDTO){
        Player player = new Player();
        BeanUtils.copyProperties(playerDTO, player);
        return playerRepository.save(player);
    }

    public List<Player> readAll(){
        return  playerRepository.findAll();
    }

    public Player readSpecific(Integer idPlayer){
        Optional<Player> optionalPlayer = playerRepository.findById(idPlayer);
        if (optionalPlayer.isPresent()){
            return optionalPlayer.get();
        } else {
            throw new RuntimeException("\nJogador não encontrado!");
        }
    }

    public Player update(Player player){
        return playerRepository.save(player);
    }

    public void delete(Integer idPlayer){
        playerRepository.deleteById(idPlayer);
    }
}
