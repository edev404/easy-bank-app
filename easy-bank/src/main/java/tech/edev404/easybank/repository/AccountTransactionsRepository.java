package tech.edev404.easybank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.edev404.easybank.model.entity.AccountTransactions;

public interface AccountTransactionsRepository extends JpaRepository<AccountTransactions, Integer> {
    
}
