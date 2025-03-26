package com.api.bankTransfer.dto;

import com.api.bankTransfer.entity.Transfer;

public class UpdateTransferDTO {
    private String name;
    private String accountNumber;
    private String amount;
    private String description;
    private String email;
    
    public void updateTransferEntity(Transfer transfer) {
        if (this.name != null) transfer.setName(this.name);
        if (this.accountNumber != null) transfer.setAccountNumber(this.accountNumber);
        if (this.amount != null) transfer.setAmount(this.amount);
        if (this.description != null) transfer.setDescription(this.description);
        if (this.email != null) transfer.setEmail(this.email);
        // No actualizamos el pin por seguridad
    }
}
