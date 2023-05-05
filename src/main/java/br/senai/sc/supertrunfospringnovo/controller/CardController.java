package br.senai.sc.supertrunfospringnovo.controller;

import br.senai.sc.supertrunfospringnovo.model.DTO.CardDTO;
import br.senai.sc.supertrunfospringnovo.model.entity.Card;
import br.senai.sc.supertrunfospringnovo.service.CardService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/card")
@CrossOrigin
public class CardController {

    CardService cardService;

    @PostMapping("/create")
    public ResponseEntity<Card> create(@RequestBody CardDTO cardDTO){
        return ResponseEntity.ok(cardService.create(cardDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Card>> readAll(){
        return ResponseEntity.ok(cardService.readAll());
    }

    @GetMapping("/specific/{idCard}")
    public ResponseEntity<Card> readSpecific(@PathVariable Integer idCard){
        return ResponseEntity.ok(cardService.readSpecific(idCard));
    }

    @GetMapping("/names")
    public  ResponseEntity<String> readCardNames(){
        return ResponseEntity.ok(cardService.readCardNames());
    }

    @PutMapping("/edit/{idCard}")
    public ResponseEntity<Card> edit(@PathVariable Integer idCard, @RequestBody CardDTO cardDTO){
        Card card = cardService.readSpecific(idCard);
        BeanUtils.copyProperties(cardDTO, card);
        return ResponseEntity.ok(cardService.updateCard(card));
    }

    @DeleteMapping("/delete/{idCard}")
    public ResponseEntity<Card> deleteCard(@PathVariable Integer idCard){
        Card card = new Card();
        cardService.deleteCard(idCard);
        return ResponseEntity.ok(card);
    }
}
