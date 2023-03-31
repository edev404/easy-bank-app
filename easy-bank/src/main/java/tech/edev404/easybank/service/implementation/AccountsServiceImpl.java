package tech.edev404.easybank.service.implementation;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tech.edev404.easybank.model.entity.Account;
import tech.edev404.easybank.repository.AccountsRepository;
import tech.edev404.easybank.service.AccountsService;

@Service
@Primary
@RequiredArgsConstructor
public class AccountsServiceImpl implements AccountsService {

    private final AccountsRepository accountsRepository;
    
    @Override
    public Account findByCustomerId(Integer customerId) {
        return accountsRepository.findByCustomerId(customerId);
    }
    
}
