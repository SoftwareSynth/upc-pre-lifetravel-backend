package com.nexusnova.lifetravelapi.app.core.tours.domain.queries;


import java.math.BigDecimal;

public record GetTourPackagesByPriceQuery(BigDecimal minPrice, BigDecimal maxPrice) {
    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }
}
