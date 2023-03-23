package tech.edev404.easybank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/loans")
public class LoansController {

    @GetMapping
    public String handleGetLoansDetails(){
        return "Loans details";
    }
    
}
