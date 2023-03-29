package tech.edev404.easybank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.edev404.easybank.model.entity.Contact;

public interface ContactsRepository extends JpaRepository<Contact, Integer>{
    
}
