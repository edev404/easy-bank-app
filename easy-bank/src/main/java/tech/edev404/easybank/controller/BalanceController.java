package tech.edev404.easybank.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import tech.edev404.easybank.model.entity.AccountTransactions;
import tech.edev404.easybank.service.AccountTransactionsService;

@RestController
@RequestMapping("api/v1/balance")
@RequiredArgsConstructor
public class BalanceController {

    private final AccountTransactionsService accountTransactionsService;

    @GetMapping
    public List<AccountTransactions> handleGetBalanceDetails(@RequestBody Integer id){
        return accountTransactionsService.findByCustomerIdOrderByTransactionDtDesc(id);
    }
}
