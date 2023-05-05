package br.senai.sc.supertrunfospringnovo.service;

import br.senai.sc.supertrunfospringnovo.model.DTO.CardDTO;
import br.senai.sc.supertrunfospringnovo.model.entity.Card;
import br.senai.sc.supertrunfospringnovo.repository.CardRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CardService {

    private CardRepository cardRepository;

    public Card create(CardDTO cardDTO){
        Card card = new Card();
        BeanUtils.copyProperties(cardDTO, card);
        return cardRepository.save(card);
    }

    public List<Card> readAll(){
        return cardRepository.findAll();
    }

    public Card readSpecific(Integer idCard){
        Optional<Card> optionalCard = cardRepository.findById(idCard);
        if (optionalCard.isPresent()){
            return optionalCard.get();
        } else {
            throw new RuntimeException("\nCarta não encontrada!");
        }
    }

    public String readCardNames(){
        String text = "";
        List<Card> listCards = readAll();
        for (Card card : listCards) {
            text += card.getIdCard() + " - " + card.getName() + "\n";
        }
        return text;
    }

    public Card updateCard(Card card){
        return cardRepository.save(card);
    }

    public void deleteCard(Integer idCard){
        cardRepository.deleteById(idCard);
    }
}
