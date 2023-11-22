package com.nexusnova.lifetravelapi.app.IOT.resources.requests;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(description = "TrackingWereable (Request)")
public class TrackingWereableRequestDto {

    @Schema(description = "Latitud del GPS Tracker")
    private BigDecimal latitude;
    @Schema(description = "Longitud del GPS Tracker")
    private BigDecimal longitude;

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }
}
