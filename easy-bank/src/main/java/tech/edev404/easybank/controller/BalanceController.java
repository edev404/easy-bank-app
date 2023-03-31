package tech.edev404.easybank.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public List<AccountTransactions> handleGetBalanceDetails(@RequestParam Integer id){
        System.out.println("ID RECIBIDO: " +id);
        List<AccountTransactions> at = accountTransactionsService.findByCustomerIdOrderByTransactionDtDesc(id);
        at.forEach(a -> System.out.println(a.toString()));
        return at;
    }
}
