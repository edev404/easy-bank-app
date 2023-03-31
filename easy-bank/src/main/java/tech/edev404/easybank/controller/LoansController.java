package tech.edev404.easybank.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import tech.edev404.easybank.model.entity.Loan;
import tech.edev404.easybank.service.LoansService;

@RestController
@RequestMapping("api/v1/loans")
@RequiredArgsConstructor
public class LoansController {

    private final LoansService loansService;

    @GetMapping
    public List<Loan> handleGetLoansDetails(@RequestBody Integer id){
        return loansService.findByCustomerIdOrderByStartDtDesc(id);
    }
    
}
