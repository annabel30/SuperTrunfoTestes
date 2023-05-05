package br.senai.sc.supertrunfospringnovo.model.DTO;

import br.senai.sc.supertrunfospringnovo.model.enums.Element;
import br.senai.sc.supertrunfospringnovo.model.enums.Region;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardDTO {

    private String name;
    private int atk;
    private int criticalRate;
    private int criticalDamage;
    private int elementalMastery;
    private int energyRecharge;
    private Element element;
    private Region region;
}
