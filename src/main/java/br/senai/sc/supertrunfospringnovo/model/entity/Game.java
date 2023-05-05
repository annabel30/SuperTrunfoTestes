package br.senai.sc.supertrunfospringnovo.model.entity;

import lombok.Data;

import java.util.Random;

@Data
public class Game {

    private static Random generator = new Random();
    private static int startedMatch;
    private static Player playerModel;

    public static void startGame(){
        Deck.separateCards();

        startedMatch = generator.nextInt(2);
        do {
            if (startedMatch == 0){
                playerPlays();
                startedMatch = 1;
            } else {
                computerPlays();
                startedMatch = 0;
            }
        } while (Deck.getComputerDeck().size() != 0 || Deck.getUserDeck().size() != 0);

        if (Deck.getUserDeck().size() == 0){
            playerModel.setDefeats();
        } else if (Deck.getComputerDeck().size() == 0){
            playerModel.setVictories();
        }
    }

    private static void computerPlays() {
        int randomAttribute = generator.nextInt(5);
        match(randomAttribute + 1);
    }
    private static void playerPlays() {
        int chosenAttribute = 0;
        match(chosenAttribute);
    }

    private static void match(int chosenAtt) {
        boolean wonRound = Card.compareAttributes(chosenAtt);

        if (wonRound){
            Deck.playerWonRound();
        } else {
            Deck.computerWonRound();
        }
    }

    public static int getStartedMatch() {
        return startedMatch;
    }
}
