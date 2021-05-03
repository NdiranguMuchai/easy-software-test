package com.ndirangu.easysoftware.repository;

import com.ndirangu.easysoftware.model.Customer;
import com.ndirangu.easysoftware.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
    Customer findCustomerByLoans(Loan loan);
    Optional<Customer> findByCustomerId(String customerId);
}
