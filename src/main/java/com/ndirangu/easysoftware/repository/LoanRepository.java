package com.ndirangu.easysoftware.repository;

import com.ndirangu.easysoftware.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LoanRepository extends JpaRepository<Loan, UUID> {

}
