package br.senai.sc.supertrunfospringnovo.repository;

import br.senai.sc.supertrunfospringnovo.model.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
}
