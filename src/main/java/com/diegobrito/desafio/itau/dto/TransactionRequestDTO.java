package com.diegobrito.desafio.itau.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;

public class TransactionRequestDTO {
    @NotNull
    private Double amount;
    @NotNull
    private OffsetDateTime moment;

    public Double getAmount() {
        return amount;
    }

    public OffsetDateTime getMoment() {
        return moment;
    }
}
