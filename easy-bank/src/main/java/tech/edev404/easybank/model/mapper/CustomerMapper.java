package tech.edev404.easybank.model.mapper;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tech.edev404.easybank.model.dto.CustomerDto;
import tech.edev404.easybank.model.entity.Customer;
import tech.edev404.easybank.model.entity.RoleEnum;

@Service
@RequiredArgsConstructor
public class CustomerMapper implements GenericMapper<Customer, CustomerDto>{

    private final PasswordEncoder passwordEncoder;

    @Override
    public Customer dtoToPojo(CustomerDto dto) {
        return Customer.builder()
        .email(dto.getEmail())
        .password(passwordEncoder.encode(dto.getPassword()))
        .authority(RoleEnum.valueOf(dto.getAuthority()))
        .enabled(false)
        .accountNonLocked(true)
        .credentialsNonExpired(true)
        .accountNonExpired(true)
        .build();
    }

    @Override
    public CustomerDto pojoToDto(Customer pojo) {
        return CustomerDto.builder()
        .email(pojo.getEmail())
        .password("")
        .authority(pojo.getAuthority().toString())
        .build();
    }
    
}
