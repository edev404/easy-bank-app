package tech.edev404.easybank.service;

import java.util.Optional;

import tech.edev404.easybank.model.entity.Customer;

public interface CustomerService {
    
    Optional<Customer> findByEmail(String email);

    void save(Customer customer);
    
}
