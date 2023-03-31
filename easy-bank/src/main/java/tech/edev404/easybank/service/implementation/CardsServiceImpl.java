package tech.edev404.easybank.service.implementation;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tech.edev404.easybank.model.entity.Card;
import tech.edev404.easybank.repository.CardsRepository;
import tech.edev404.easybank.service.CardsService;

@Service
@Primary
@RequiredArgsConstructor
public class CardsServiceImpl implements CardsService {

    private final CardsRepository cardsRepository;
    
    @Override
    public List<Card> findByCustomerId(int customerId) {
        return cardsRepository.findByCustomerId(customerId);
    }
    
}
