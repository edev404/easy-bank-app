package tech.edev404.easybank.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.edev404.easybank.model.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID>{

    Optional<Customer> findByEmail(String email);
    
}
