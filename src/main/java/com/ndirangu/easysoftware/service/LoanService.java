package com.ndirangu.easysoftware.service;

import com.ndirangu.easysoftware.model.Loan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface LoanService {
    Loan save(Loan loan);
    Page<Loan> list(Pageable pageable);
    Loan findById(UUID id) throws Exception;
    List<Loan> findByLoaneeId(UUID loaneeId);
    Loan update(UUID id) throws Exception;
}
