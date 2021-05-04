package com.ndirangu.easysoftware.dto;

import java.time.LocalDate;
import java.util.UUID;

/**
 * These DTO classes are used in the presentation layer to control what the client has access to.
 */
public class LoanDTO {
    private UUID id;
    private String transactionId;
    private Double amount;
    private Long loanCode;
    private LocalDate loanDate;
    private LocalDate loanDueDate;
    private String customerId;

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

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getLoanDueDate() {
        return loanDueDate;
    }

    public void setLoanDueDate(LocalDate loanDueDate) {
        this.loanDueDate = loanDueDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

}
