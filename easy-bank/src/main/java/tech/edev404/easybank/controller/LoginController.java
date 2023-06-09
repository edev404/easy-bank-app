package tech.edev404.easybank.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import tech.edev404.easybank.model.dto.CustomerDto;
import tech.edev404.easybank.model.entity.Customer;
import tech.edev404.easybank.model.entity.enums.RoleEnum;
import tech.edev404.easybank.model.mapper.CustomerMapper;
import tech.edev404.easybank.service.CustomersService;

@RestController
@RequestMapping("api/v1/")
@RequiredArgsConstructor
public class LoginController {

    private final CustomersService customerService;
    private final CustomerMapper customerMapper;

    @GetMapping("user")
    public CustomerDto handleGetCustomer(Authentication authentication){
        Customer customer = customerService.findByEmail(authentication.getName()).get();
        CustomerDto dto = customerMapper.pojoToDto(customer);
        System.out.println(customer.toString());
        return dto;
    }

    @PostMapping("sign-up")
    public ResponseEntity<String> handleRegisterNewUser(@Validated @RequestBody CustomerDto customerDto) {
        Optional<Customer> customerOptional = customerService.findByEmail(customerDto.getEmail());
        if(customerOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("email unavailable");
        }
        Customer customer = customerMapper.dtoToPojo(customerDto);
        if (customer.getAuthority().equals(RoleEnum.admin)) {
            customer.setEnabled(false);
        }
        try{
            customerService.save(customer);
            return ResponseEntity.status(HttpStatus.CREATED).body("successfull registration");
        } catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An exception occured due to: " + ex.getMessage());
        }
    }
}
