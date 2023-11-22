package com.nexusnova.lifetravelapi.app.core.tours.resources.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Schema(description="Meeting Point (Request)")
public class MeetingPointRequestDto {

    @Schema(description="Latitud")
    private BigDecimal latitude;
    @Schema(description="Longitud")
    private BigDecimal longitude;

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }
}
