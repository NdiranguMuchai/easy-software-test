package com.ndirangu.easysoftware.controller;

import com.ndirangu.easysoftware.converter.LoanDTOConverter;
import com.ndirangu.easysoftware.dto.LoanDTO;
import com.ndirangu.easysoftware.model.Customer;
import com.ndirangu.easysoftware.model.Loan;
import com.ndirangu.easysoftware.service.CustomerService;
import com.ndirangu.easysoftware.service.LoanService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/loan")
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
    public LoanDTO create(@RequestBody LoanDTO loanDTO) throws Exception{
        Customer loanee = customerService.findByCustomerId(loanDTO.getCustomerId());

        Loan loanToSave = loanDTOConverter.convertDTOToLoan(loanDTO);

        loanToSave.setLoanee(loanee);
        return loanDTOConverter.convertLoanTODTO(loanService.save(loanToSave));
    }

    @GetMapping("{id}")
    public LoanDTO findOne(@PathVariable UUID id) throws Exception{
        Loan loan = loanService.findById(id);
        return loanDTOConverter.convertLoanTODTO(loan);
    }


}
