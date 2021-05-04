package com.ndirangu.easysoftware.controller;

import com.ndirangu.easysoftware.converter.CustomerDTOConverter;
import com.ndirangu.easysoftware.dto.CustomerDTO;
import com.ndirangu.easysoftware.model.Customer;
import com.ndirangu.easysoftware.service.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;
    private final CustomerDTOConverter customerDTOConverter;

    public CustomerController(CustomerService customerService,
                              CustomerDTOConverter customerDTOConverter) {
        this.customerService = customerService;
        this.customerDTOConverter = customerDTOConverter;
    }

    @PostMapping("/create")
    CustomerDTO save(@RequestBody CustomerDTO customerDTO){
        Customer customer = customerDTOConverter.convertDTOToCustomer(customerDTO);

        return customerDTOConverter.convertCustomerToDTO(customerService.save(customer));
    }

}
