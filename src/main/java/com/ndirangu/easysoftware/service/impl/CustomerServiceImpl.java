package com.ndirangu.easysoftware.service.impl;

import com.ndirangu.easysoftware.model.Customer;
import com.ndirangu.easysoftware.repository.CustomerRepository;
import com.ndirangu.easysoftware.service.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer findByObjectId(UUID id) throws Exception {
        return customerRepository.findById(id).orElseThrow(()-> new Exception("Id "+id+" not found for customer"));
    }

    @Override
    public Customer findByCustomerId(String customerId) throws Exception {
        return customerRepository.findByCustomerId(customerId)
                .orElseThrow(()-> new Exception("Customer ID "+customerId+" not found"));
    }

    @Override
    public Page<Customer> list(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(UUID id) throws Exception{
        Customer customer =  customerRepository.findById(id).orElseThrow(()-> new Exception("Id "+id+" not found for customer"));
        customer.setId(id);

        return customerRepository.save(customer);
    }
}
