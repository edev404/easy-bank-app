package tech.edev404.easybank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.edev404.easybank.model.entity.Loan;

public interface LoansRepository extends JpaRepository<Loan, Integer> {

    List<Loan> findByCustomerIdOrderByStartDtDesc(int customerId);
    
}
