package br.senai.sc.supertrunfospringnovo.model.DTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDTO {

    private String name;
    private Integer age;
    private char gender;
    private String region;
    private String element;
    private String weapon;
    private Integer password;
}
