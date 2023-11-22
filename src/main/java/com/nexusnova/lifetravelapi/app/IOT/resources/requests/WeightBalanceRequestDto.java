package com.nexusnova.lifetravelapi.app.IOT.resources.requests;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(description = "Weight Balance (Request)")
public class WeightBalanceRequestDto {

    @Schema(description = "Peso")
    private Double weight;

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}
