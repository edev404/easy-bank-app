package tech.edev404.easybank.service.implementation;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tech.edev404.easybank.model.entity.Loan;
import tech.edev404.easybank.repository.LoansRepository;
import tech.edev404.easybank.service.LoansService;

@Service
@Primary
@RequiredArgsConstructor
public class LoansServiceImpl implements LoansService {

    private final LoansRepository loansRepository;
    
    @Override
    public List<Loan> findByCustomerIdOrderByStartDtDesc(int customerId) {
        return loansRepository.findByCustomerIdOrderByStartDtDesc(customerId);
    }
    
}
