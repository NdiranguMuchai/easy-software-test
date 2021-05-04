package com.ndirangu.easysoftware.controller;

import com.ndirangu.easysoftware.converter.CustomerDTOConverter;
import com.ndirangu.easysoftware.dto.CustomerDTO;
import com.ndirangu.easysoftware.model.Customer;
import com.ndirangu.easysoftware.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
@Api(tags = {"Customer"})
public class CustomerController {
    private final CustomerService customerService;
    private final CustomerDTOConverter customerDTOConverter;

    public CustomerController(CustomerService customerService,
                              CustomerDTOConverter customerDTOConverter) {
        this.customerService = customerService;
        this.customerDTOConverter = customerDTOConverter;
    }

    @PostMapping("/create")
    @ApiOperation(value = "Creates a customer object")
    CustomerDTO save(@RequestBody CustomerDTO customerDTO){
        Customer customer = customerDTOConverter.convertDTOToCustomer(customerDTO);

        return customerDTOConverter.convertCustomerToDTO(customerService.save(customer));
    }

}
