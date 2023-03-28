package tech.edev404.easybank.service.implementation;

import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tech.edev404.easybank.model.entity.Customer;
import tech.edev404.easybank.repository.CustomerRepository;
import tech.edev404.easybank.service.CustomerService;

@Service
@Primary
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Optional<Customer> findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    @Override
    public void save(Customer customer) {
       customerRepository.save(customer);
    }
    
}
