package tech.edev404.easybank.service;

import java.util.List;

import tech.edev404.easybank.model.entity.Loan;

public interface LoansService {

    List<Loan> findByCustomerIdOrderByStartDtDesc(int customerId);
    
}
