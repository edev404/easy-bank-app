package tech.edev404.easybank.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import tech.edev404.easybank.model.dto.CustomerDto;
import tech.edev404.easybank.model.entity.Customer;
import tech.edev404.easybank.model.entity.RoleEnum;
import tech.edev404.easybank.model.mapper.CustomerMapper;
import tech.edev404.easybank.service.CustomerService;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin("*")
@RequiredArgsConstructor
public class LoginController {

    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    @PostMapping("sign-up")
    public ResponseEntity<String> handleRegisterNewUser(@Validated @RequestBody CustomerDto customerDto) {
        Optional<Customer> customerOptional = customerService.findByEmail(customerDto.getEmail());
        if(customerOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("email unavailable");
        }
        Customer customer = customerMapper.dtoToPojo(customerDto);
        if (customer.getAuthority().equals(RoleEnum.ADMINISTRATOR)) {
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
