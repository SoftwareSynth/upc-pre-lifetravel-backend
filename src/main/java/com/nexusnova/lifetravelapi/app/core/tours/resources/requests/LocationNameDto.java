package com.nexusnova.lifetravelapi.app.core.tours.resources.requests;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class LocationNameDto {
    private Long id;
    private String name;
    private BigDecimal latitude;
    private BigDecimal longitude;
}
