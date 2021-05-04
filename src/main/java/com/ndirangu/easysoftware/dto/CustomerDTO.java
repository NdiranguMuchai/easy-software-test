package com.ndirangu.easysoftware.dto;

import java.util.List;
import java.util.UUID;

/**
 * These DTO classes are used in the presentation layer to control what the client has access to.
 */
public class CustomerDTO {
    private UUID id;
    private String customerId;
    private List<UUID> loanIds;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<UUID> getLoanIds() {
        return loanIds;
    }

    public void setLoanIds(List<UUID> loanIds) {
        this.loanIds = loanIds;
    }
}
