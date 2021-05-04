package com.ndirangu.easysoftware.controller;

import com.ndirangu.easysoftware.converter.LoanDTOConverter;
import com.ndirangu.easysoftware.dto.LoanDTO;
import com.ndirangu.easysoftware.model.Customer;
import com.ndirangu.easysoftware.model.Loan;
import com.ndirangu.easysoftware.service.CustomerService;
import com.ndirangu.easysoftware.service.LoanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/loan")
@Api(tags = {"Loan"})
public class LoanController {
    private final LoanService loanService;
    private final LoanDTOConverter loanDTOConverter;
    private final CustomerService customerService;

    public LoanController(LoanService loanService,
                          LoanDTOConverter loanDTOConverter,
                          CustomerService customerService) {
        this.loanService = loanService;
        this.loanDTOConverter = loanDTOConverter;
        this.customerService = customerService;
    }

    @PostMapping("/create")
    @ApiOperation(value = "Creates a loan object")
    public LoanDTO create(@RequestBody LoanDTO loanDTO) throws Exception{
        Customer loanee = customerService.findByCustomerId(loanDTO.getCustomerId());

        Loan loanToSave = loanDTOConverter.convertDTOToLoan(loanDTO);

        loanToSave.setLoanee(loanee);
        if (loanToSave.getLoanDate().isAfter(loanToSave.getLoanDueDate())){
            throw new Exception("Due date cannot be earlier than loan date");
        }
        return loanDTOConverter.convertLoanTODTO(loanService.save(loanToSave));
    }

    @GetMapping("{id}")
    @ApiOperation(value = "Finds a loan object given its ID")
    public LoanDTO findOne(@PathVariable UUID id) throws Exception{
        Loan loan = loanService.findById(id);
        return loanDTOConverter.convertLoanTODTO(loan);
    }

    @GetMapping("/customer/{customerId}")
    @ApiOperation(value = "Returns a list of loans belonging to a customer")
    public List<LoanDTO> findByCustomer(@PathVariable String customerId){
        return loanService.findByCustomerId(customerId)
                .stream()
                .map(loanDTOConverter::convertLoanTODTO)
                .collect(Collectors.toList());
    }

}
