package com.nexusnova.lifetravelapi.app.core.tours.resources.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Getter
@Setter
@Schema(description="Tour Package (Request)")
public class TourPackageRequestDto {
    private String agencyId;
    private String destiny;
    private String title;
    private String imgUrl;
    private String description;
    private BigInteger regionId;
    private Boolean visible;
    private BigDecimal price;
    private BigDecimal meetingPointLatitude;
    private BigDecimal meetingPointLongitude;
    private List<ActivityRequestDto> activities;
    private List<LocationNameDto> destinations;
    //private List<ScheduleDto> schedules;
}
