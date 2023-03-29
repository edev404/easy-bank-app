package tech.edev404.easybank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.edev404.easybank.model.entity.Customer;

public interface CustomersRepository extends JpaRepository<Customer, Integer> {

    Optional<Customer> findByEmail(String email);
    
}
