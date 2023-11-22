package com.nexusnova.lifetravelapi.app.core.tours.resources.details;

import com.nexusnova.lifetravelapi.app.core.tours.domain.model.Activity;
import com.nexusnova.lifetravelapi.app.core.tours.domain.model.Schedule;
import com.nexusnova.lifetravelapi.app.core.tours.resources.requests.LocationNameDto;
import com.nexusnova.lifetravelapi.app.core.tours.resources.requests.ScheduleDto;
import com.nexusnova.lifetravelapi.app.core.tours.resources.summaries.ActivitySummaryDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Schema(name = "TourPackage (Detail)")
@Getter
@Setter
public class TourPackageDetailDto {

    @Schema(name = "Id del paquete")
    private Long id;
    @Schema(name = "Nombre del Usuario")
    private String title;
    @Schema(name = "Nombre del departamento")
    private String destiny;
    @Schema(name = "Nombre del Usuario")
    private String description;
    @Schema(name = "Nombre del Usuario")
    private String imgUrl;
    @Schema(name = "Rating")
    private Float rating;
    @Schema(name = "Id Agencia")
    private String agencyId;
    @Schema(name = "Precio")
    private BigDecimal price;
    @Schema(name = "Id Region")
    private Long regionId;
    @Schema(name = "Visible")
    private Boolean visible;
    @Schema(name = "Latitud de encuentro")
    private BigDecimal meetingPointLatitude;
    @Schema(name = "Longitud de encuentro")
    private BigDecimal meetingPointLongitude;
    @Schema(name = "Destinos")
    private List<LocationNameDto> destinations;
    @Schema(name = "Actividades")
    private List<ActivitySummaryDto> activities;
    //@Schema(name = "Horarios")
    //private List<ScheduleDto> schedules;
}
