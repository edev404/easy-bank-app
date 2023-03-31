package tech.edev404.easybank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import tech.edev404.easybank.model.entity.Account;
import tech.edev404.easybank.service.AccountsService;

@RestController
@RequestMapping("api/v1/account")
@RequiredArgsConstructor
public class AccountController {

  private final AccountsService accountsService;

    @GetMapping
    public Account handleGetAccountDetails(@RequestBody Integer id) {
      return accountsService.findByCustomerId(id);
    }
    
}
