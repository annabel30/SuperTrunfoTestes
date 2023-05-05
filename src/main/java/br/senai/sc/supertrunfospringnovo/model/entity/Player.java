package br.senai.sc.supertrunfospringnovo.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPlayer;
    private String name;
    private Integer age;
    private char gender;
    private String region;
    private String element;
    private String weapon;
    private Integer password;
    private Integer victories = 0;
    private Integer defeats = 0;

    public void setVictories() {
        this.victories++;
    }
    public void setDefeats() {
        this.defeats++;
    }
}
