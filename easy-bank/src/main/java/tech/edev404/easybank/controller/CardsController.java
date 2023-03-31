package tech.edev404.easybank.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import tech.edev404.easybank.model.entity.Card;
import tech.edev404.easybank.service.CardsService;

@RestController
@RequestMapping("api/v1/cards")
@RequiredArgsConstructor
public class CardsController {

    private final CardsService cardsService;
    
    @GetMapping
    public List<Card> handleGetCardsDetails(@RequestBody Integer id){
        return cardsService.findByCustomerId(id);
    }
    
}
