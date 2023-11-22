package com.nexusnova.lifetravelapi.app.IOT.resources.summaries;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Weight Balance (Summary)")
public class WeightBalanceSummaryDto {

    @Schema(description = "Peso Actual Sumarizado")
    private Double actualWeight;

    @Schema(description = "Peso Maximo del Transporte")
    private Double maxWeight;

    public Double getActualWeight() {
        return actualWeight;
    }

    public void setActualWeight(Double actualWeight) {
        this.actualWeight = actualWeight;
    }

    public Double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Double maxWeight) {
        this.maxWeight = maxWeight;
    }
}
