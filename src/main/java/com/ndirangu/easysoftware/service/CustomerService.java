package com.ndirangu.easysoftware.service;

import com.ndirangu.easysoftware.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface CustomerService {
    Customer findByObjectId(UUID id) throws Exception;
    Customer findByCustomerId(String customerId)throws Exception;
    Page<Customer> list(Pageable pageable);
    Customer save(Customer customer);
    Customer update(UUID id) throws Exception;
}
