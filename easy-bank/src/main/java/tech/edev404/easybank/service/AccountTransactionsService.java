package tech.edev404.easybank.service;

import java.util.List;

import tech.edev404.easybank.model.entity.AccountTransactions;

public interface AccountTransactionsService {

    List<AccountTransactions> findByCustomerIdOrderByTransactionDtDesc(Integer customerId);
    
}
