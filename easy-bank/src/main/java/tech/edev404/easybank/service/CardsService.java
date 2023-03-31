package tech.edev404.easybank.service;

import java.util.List;

import tech.edev404.easybank.model.entity.Card;

public interface CardsService {

    List<Card> findByCustomerId(int customerId);
    
}
