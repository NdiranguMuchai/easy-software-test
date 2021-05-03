package com.ndirangu.easysoftware.service.impl;

import com.ndirangu.easysoftware.model.Loan;
import com.ndirangu.easysoftware.repository.LoanRepository;
import com.ndirangu.easysoftware.service.LoanService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LoanServiceImpl implements LoanService {
    private final LoanRepository loanRepository;

    public LoanServiceImpl(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public Loan save(Loan loan) {
        return loanRepository.save(loan);
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
    public List<Loan> findByLoaneeId(UUID loaneeId) {
        return loanRepository.findAllByLoaneeId(loaneeId);
    }

    @Override
    public Loan update(UUID id) throws Exception {
       Loan loan = loanRepository.findById(id).orElseThrow(()-> new Exception("Loan with id "+id+" not found"));
        loan.setId(id);
        return loanRepository.save(loan);
    }

}
