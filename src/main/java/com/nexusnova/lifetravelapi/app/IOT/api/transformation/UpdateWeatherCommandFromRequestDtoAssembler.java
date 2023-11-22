package com.nexusnova.lifetravelapi.app.IOT.api.transformation;

import com.nexusnova.lifetravelapi.app.IOT.domain.commands.UpdateWeatherCommand;
import com.nexusnova.lifetravelapi.app.IOT.resources.requests.WeatherSensorRequestDto;

public class UpdateWeatherCommandFromRequestDtoAssembler {
    public static UpdateWeatherCommand toCommandFromDto(Long id, WeatherSensorRequestDto requestDto) {
        return new UpdateWeatherCommand(id, requestDto);
    }
}