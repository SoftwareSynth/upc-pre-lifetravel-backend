package com.nexusnova.lifetravelapi.app.IOT.api.REST;

import com.nexusnova.lifetravelapi.app.IOT.api.transformation.UpdateLocationCommandFromRequestDtoAssembler;
import com.nexusnova.lifetravelapi.app.IOT.api.transformation.UpdateWeatherCommandFromRequestDtoAssembler;
import com.nexusnova.lifetravelapi.app.IOT.domain.queries.GetWeaterByTouristQuery;
import com.nexusnova.lifetravelapi.app.IOT.domain.services.WeatherSensorCommandService;
import com.nexusnova.lifetravelapi.app.IOT.domain.services.WeatherSensorQueryService;
import com.nexusnova.lifetravelapi.app.IOT.resources.requests.WeatherSensorRequestDto;
import com.nexusnova.lifetravelapi.app.IOT.resources.summaries.WeatherSummaryDto;
import com.nexusnova.lifetravelapi.configuration.constants.HeaderConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.nexusnova.lifetravelapi.configuration.messages.ConfigurationMessages.GPS_UPDATED;
import static com.nexusnova.lifetravelapi.configuration.messages.ConfigurationMessages.WEATHER_SENSOR_UPDATED;

@RestController
@RequestMapping("/api/v1/weather-sensors")
@Tag(name="Weather Sensors Controller")
@CrossOrigin
public class WeatherSensorController {

    private final WeatherSensorCommandService weatherSensorCommandService;
    private final WeatherSensorQueryService weatherSensorQueryService;

    @Autowired
    public WeatherSensorController(WeatherSensorCommandService weatherSensorCommandService,
                                   WeatherSensorQueryService weatherSensorQueryService) {
        this.weatherSensorCommandService = weatherSensorCommandService;
        this.weatherSensorQueryService = weatherSensorQueryService;
    }

    @GetMapping("/{touristUserId}")
    @Operation(summary = "Obtener Clima", description = "Permite ver informacion de clima.")
    public WeatherSummaryDto getTemperature(@Parameter @PathVariable("touristUserId") String touristUserId) {
        return weatherSensorQueryService.handle(new GetWeaterByTouristQuery(touristUserId));
    }

    @PutMapping("/update-weather/{sensorId}")
    @Operation(summary = "Actualizar Clima", description = "Permite actualizar el Clima del Sensor.")
    public void updateWeather(@Parameter @PathVariable("sensorId") Long sensorId,
                               @RequestBody @Valid WeatherSensorRequestDto requestDto,
                               HttpServletResponse response) {
        weatherSensorCommandService.handle(UpdateWeatherCommandFromRequestDtoAssembler.toCommandFromDto(sensorId, requestDto));
        response.setHeader(HeaderConstants.MESSAGES, WEATHER_SENSOR_UPDATED);
    }
}
