package br.senai.sc.supertrunfospringnovo.model.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Element {

    Anemo("Anemo"),
    Cryo("Cryo"),
    Dendro("Dendro"),
    Electro("Electro"),
    Geo("Geo"),
    Hydro("Hydro"),
    Pyro("Pyro");

    String nome;
}
