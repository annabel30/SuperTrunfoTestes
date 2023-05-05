package br.senai.sc.supertrunfospringnovo.model.entity;

import br.senai.sc.supertrunfospringnovo.service.CardService;
import lombok.Data;

import java.util.*;

@Data
public class Deck {

    private static List<Card> userDeck = new ArrayList<>();
    private static List<Card> computerDeck = new ArrayList<>();
    private static Card userCardModel;
    private static Card computerCardModel;
    private static CardService cardService;

    public static void separateCards(){
        List<Card> deckCards = cardService.readAll();
        Collections.shuffle(deckCards);
        for (int i = 0; i < deckCards.size(); i++){
            userDeck.add(deckCards.get(i));
            i++;
            computerDeck.add(deckCards.get(i));
        }
    }

    public static void createModelCards(){
        userCardModel = userDeck.get(0);
        computerCardModel = computerDeck.get(0);
    }

    public static void computerWonRound(){
        createModelCards();
        addComputerDeck(userCardModel);
        removeUserDeck();
        removeComputerDeck();
        addComputerDeck(computerCardModel);
    }

    public static void playerWonRound(){
        createModelCards();
        addUserDeck(computerCardModel);
        removeComputerDeck();
        removeUserDeck();
        addUserDeck(userCardModel);
    }

    public static void addUserDeck(Card card){
        userDeck.add(card);
    }
    public static void addComputerDeck(Card card){
        computerDeck.add(card);
    }

    public static void removeUserDeck(){
        userDeck.remove(0);
    }
    public static void removeComputerDeck(){
        computerDeck.remove(0);
    }

    public static List<Card> getUserDeck() {
        return userDeck;
    }
    public static List<Card> getComputerDeck() {
        return computerDeck;
    }
}
