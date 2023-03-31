package tech.edev404.easybank.service;

import tech.edev404.easybank.model.entity.Account;

public interface AccountsService {

    Account findByCustomerId(Integer customerId);
    
}
