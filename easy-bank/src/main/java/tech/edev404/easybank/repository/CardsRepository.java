package tech.edev404.easybank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.edev404.easybank.model.entity.Card;

public interface CardsRepository extends JpaRepository<Card, Integer> {
    
}
