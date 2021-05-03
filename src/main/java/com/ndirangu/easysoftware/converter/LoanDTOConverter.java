package com.ndirangu.easysoftware.converter;

import com.ndirangu.easysoftware.dto.LoanDTO;
import com.ndirangu.easysoftware.model.Loan;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class LoanDTOConverter {

    public LoanDTO convertLoanTODTO(Loan loan){
        LoanDTO loanDTO = new LoanDTO();
        BeanUtils.copyProperties(loan, loanDTO);

        loanDTO.setLoaneeId(loan.getLoanee().getId());

        return loanDTO;
    }

    public Loan convertDTOToLoan(LoanDTO loanDTO){
        Loan loan = new Loan();
        BeanUtils.copyProperties(loanDTO, loan);

        return loan;
    }
}
