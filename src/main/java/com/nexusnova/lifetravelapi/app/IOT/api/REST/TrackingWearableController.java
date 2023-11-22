package com.nexusnova.lifetravelapi.app.IOT.api.REST;

import com.nexusnova.lifetravelapi.app.IOT.api.transformation.UpdateLocationCommandFromRequestDtoAssembler;
import com.nexusnova.lifetravelapi.app.IOT.domain.queries.GetTrackingWereablesByAgencyQuery;
import com.nexusnova.lifetravelapi.app.IOT.domain.services.TrackingWearableCommandService;
import com.nexusnova.lifetravelapi.app.IOT.domain.services.TrackingWereableQueryService;
import com.nexusnova.lifetravelapi.app.IOT.domain.services.WeatherSensorQueryService;
import com.nexusnova.lifetravelapi.app.IOT.mapper.IOTMapper;
import com.nexusnova.lifetravelapi.app.IOT.resources.requests.TrackingWereableRequestDto;
import com.nexusnova.lifetravelapi.app.IOT.resources.summaries.TrackingWereableSummayDto;
import com.nexusnova.lifetravelapi.app.IOT.resources.summaries.WeatherSummaryDto;
import com.nexusnova.lifetravelapi.configuration.constants.HeaderConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.nexusnova.lifetravelapi.configuration.messages.ConfigurationMessages.GPS_UPDATED;

@RestController
@RequestMapping("/api/v1/gps")
@Tag(name="Tracking Wereable Controller")
@CrossOrigin
public class TrackingWearableController {

    private final TrackingWearableCommandService trackingWereableCommandService;
    private final TrackingWereableQueryService trackingWereableQueryService;


    public TrackingWearableController(TrackingWearableCommandService trackingWereableCommandService,
                                      TrackingWereableQueryService trackingWereableQueryService) {
        this.trackingWereableCommandService = trackingWereableCommandService;
        this.trackingWereableQueryService = trackingWereableQueryService;
    }


    @GetMapping("/{agencyUserId}")
    @Operation(summary = "Obtener GPS's", description = "Permite ver los gps de los turistas.")
    public List<TrackingWereableSummayDto> getLocations(@Parameter @PathVariable("agencyUserId") String agencyUserId) {
        return trackingWereableQueryService.handle(new GetTrackingWereablesByAgencyQuery(agencyUserId));
    }

    @PutMapping("/update-location/{gpsId}")
    @Operation(summary = "Actualizar Ubicacion", description = "Permite actualizar la ubicacion del GPS Tracker.")
    public void updateLocation(@Parameter @PathVariable("gpsId") Long gpsId,
                               @RequestBody @Valid TrackingWereableRequestDto requestDto,
                               HttpServletResponse response) {
        trackingWereableCommandService.handle(UpdateLocationCommandFromRequestDtoAssembler.toCommandFromDto(gpsId, requestDto));
        response.setHeader(HeaderConstants.MESSAGES, GPS_UPDATED);
    }
}
