package tech.edev404.easybank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.edev404.easybank.model.entity.Account;

public interface AccountsRepository extends JpaRepository<Account, Integer> {

    Account findByCustomerId(Integer customerId);
    
}
