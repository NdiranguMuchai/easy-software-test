package com.ndirangu.easysoftware.dto;

import java.util.Date;
import java.util.UUID;

/**
 * These DTO classes are used in the presentation layer to control what the client has access to.
 */
public class LoanDTO {
    private UUID id;
    private String transactionId;
    private Double amount;
    private Long loanCode;
    private Date loanDate;
    private Date loanDueDate;
    private UUID loaneeId;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getLoanCode() {
        return loanCode;
    }

    public void setLoanCode(Long loanCode) {
        this.loanCode = loanCode;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public Date getLoanDueDate() {
        return loanDueDate;
    }

    public void setLoanDueDate(Date loanDueDate) {
        this.loanDueDate = loanDueDate;
    }

    public UUID getLoaneeId() {
        return loaneeId;
    }

    public void setLoaneeId(UUID loaneeId) {
        this.loaneeId = loaneeId;
    }
}
