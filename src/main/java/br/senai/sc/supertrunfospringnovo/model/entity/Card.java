package br.senai.sc.supertrunfospringnovo.model.entity;

import br.senai.sc.supertrunfospringnovo.model.enums.Element;
import br.senai.sc.supertrunfospringnovo.model.enums.Region;
import jakarta.persistence.*;
import lombok.*;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCard;
    private String name;
    private int atk;
    private int criticalRate;
    private int criticalDamage;
    private int elementalMastery;
    private int energyRecharge;
    @Enumerated(EnumType.STRING)
    private Element element;
    @Enumerated(EnumType.STRING)
    private Region region;
    private String image;

    public static boolean compareAttributes(int attribute){
        Card modelCardUser = Deck.getUserDeck().get(0);
        Card modelCardComputer = Deck.getComputerDeck().get(0);

        int attributeUserValue = 0;
        int attributeComputerValue = 0;

        switch (attribute) {
            case 1 -> {
                attributeUserValue = modelCardUser.getAtk();
                attributeComputerValue = modelCardComputer.getAtk();
            }
            case 2 -> {
                attributeUserValue = modelCardUser.getCriticalRate();
                attributeComputerValue = modelCardComputer.getCriticalRate();
            }
            case 3 -> {
                attributeUserValue = modelCardUser.getCriticalDamage();
                attributeComputerValue = modelCardComputer.getCriticalDamage();
            }
            case 4 -> {
                attributeUserValue = modelCardUser.getElementalMastery();
                attributeComputerValue = modelCardComputer.getElementalMastery();
            }
            case 5 -> {
                attributeUserValue = modelCardUser.getEnergyRecharge();
                attributeComputerValue = modelCardComputer.getEnergyRecharge();
            }
        }
        if (attributeUserValue > attributeComputerValue){
            return true;
        } else if (attributeUserValue < attributeComputerValue){
            return false;
        } else {
            return Game.getStartedMatch() == 0;
        }
    }
}
