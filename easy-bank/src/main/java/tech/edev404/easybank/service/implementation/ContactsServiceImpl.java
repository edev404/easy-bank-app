package tech.edev404.easybank.service.implementation;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tech.edev404.easybank.model.entity.Contact;
import tech.edev404.easybank.repository.ContactsRepository;
import tech.edev404.easybank.service.ContactsService;

@Service
@Primary
@RequiredArgsConstructor
public class ContactsServiceImpl implements ContactsService {

    private final ContactsRepository contactsRepository;
    
    @Override
    public Contact save(Contact contact) {
        contactsRepository.save(contact);
        return contact;
    }
    
}
