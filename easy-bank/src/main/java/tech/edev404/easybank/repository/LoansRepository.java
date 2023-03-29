package tech.edev404.easybank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.edev404.easybank.model.entity.Loan;

public interface LoansRepository extends JpaRepository<Loan, Integer> {
    
}
