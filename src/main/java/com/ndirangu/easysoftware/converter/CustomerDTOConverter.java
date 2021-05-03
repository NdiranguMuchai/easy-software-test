package com.ndirangu.easysoftware.converter;

import com.ndirangu.easysoftware.dto.CustomerDTO;
import com.ndirangu.easysoftware.model.Customer;
import com.ndirangu.easysoftware.model.Loan;
import com.ndirangu.easysoftware.repository.LoanRepository;
import com.ndirangu.easysoftware.service.LoanService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class CustomerDTOConverter {
    private final LoanRepository loanRepository;

    public CustomerDTOConverter(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public CustomerDTO convertCustomerToDTO(Customer customer){
        CustomerDTO customerDTO = new CustomerDTO();
        BeanUtils.copyProperties(customer, customerDTO);

        List<UUID> loanIds = new ArrayList<>();

        if (customer.getLoans() != null){
            customer.getLoans().forEach(loan -> loanIds.add(loan.getId()));
        }

        customerDTO.setLoanIds(loanIds);

        return customerDTO;
    }

    public Customer convertDTOToCustomer(CustomerDTO customerDTO){
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO, customer);

        List<UUID> loanIds = customerDTO.getLoanIds();

        if (loanIds != null){
            List<Loan> loans = loanRepository.findAll();
            customer.setLoans(loans);
        }

        return customer;
    }
}
