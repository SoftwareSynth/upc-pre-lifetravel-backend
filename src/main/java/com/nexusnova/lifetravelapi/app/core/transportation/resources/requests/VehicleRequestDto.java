package com.nexusnova.lifetravelapi.app.core.transportation.resources.requests;

import com.nexusnova.lifetravelapi.app.core.transportation.domain.enums.VehicleStatus;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class VehicleRequestDto {
    private Long id;
    private String brand;
    private String model;
    private String plate;
    private Integer capacity;
    private String driverName;
    private String img;
    private BigDecimal weight;
    private String agencyId;
    private VehicleStatus status;
}
