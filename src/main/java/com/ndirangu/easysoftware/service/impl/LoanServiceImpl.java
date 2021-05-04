package com.ndirangu.easysoftware.service.impl;

import com.ndirangu.easysoftware.model.Customer;
import com.ndirangu.easysoftware.model.Loan;
import com.ndirangu.easysoftware.repository.CustomerRepository;
import com.ndirangu.easysoftware.repository.LoanRepository;
import com.ndirangu.easysoftware.service.LoanService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class LoanServiceImpl implements LoanService {
    private final LoanRepository loanRepository;
    private final CustomerRepository customerRepository;

    public LoanServiceImpl(LoanRepository loanRepository, CustomerRepository customerRepository) {
        this.loanRepository = loanRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public Loan save(Loan loan) {
       Loan loanToSave = loanRepository.save(loan);
        Customer loanee = loanToSave.getLoanee();
//        loanee.addLoan(loanToSave);
        loanee.getLoans().add(loanToSave);
        customerRepository.save(loanee);

        return loanToSave;
    }

    @Override
    public Page<Loan> list(Pageable pageable) {
        return loanRepository.findAll(pageable);
    }

    @Override
    public Loan findById(UUID id) throws Exception {

        return loanRepository.findById(id).orElseThrow(()-> new Exception("Loan with id "+id+" not found"));
    }

    @Override
    public Loan update(UUID id) throws Exception {
       Loan loan = loanRepository.findById(id).orElseThrow(()-> new Exception("Loan with id "+id+" not found"));

        loan.setLoanee(loan.getLoanee());
        loan.setLoanCode(loan.getLoanCode());
        loan.setLoanDate(loan.getLoanDate());
        loan.setTransactionId(loan.getTransactionId());

        return loanRepository.save(loan);
    }

    @Override
    public List<Loan> findByCustomerId(String customerId) {
        return loanRepository.findAllByLoanee_CustomerId(customerId);
    }
}
