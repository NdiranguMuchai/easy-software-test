package com.ndirangu.easysoftware.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Loan {
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @GeneratedValue(generator = "uuid")
    private UUID id;
    private String transactionId;
    private Double amount;
    private Long loanCode;
    private LocalDate loanDate;
    private LocalDate loanDueDate;
    @JsonIgnore
    @ManyToOne
    private Customer loanee;

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

    public Customer getLoanee() {
        return loanee;
    }

    public void setLoanee(Customer customer) {
        this.loanee = customer;
    }
}
