package tech.edev404.easybank.service.implementation;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tech.edev404.easybank.model.entity.AccountTransactions;
import tech.edev404.easybank.repository.AccountTransactionsRepository;
import tech.edev404.easybank.service.AccountTransactionsService;

@Service
@Primary
@RequiredArgsConstructor
public class AccountTransactionsServiceImpl implements AccountTransactionsService {

    private final AccountTransactionsRepository accountTransactionsRepository;
    
    @Override
    public List<AccountTransactions> findByCustomerIdOrderByTransactionDtDesc(Integer customerId) {
        return accountTransactionsRepository.findByCustomerIdOrderByTransactionDtDesc(customerId);
    }
    
}
