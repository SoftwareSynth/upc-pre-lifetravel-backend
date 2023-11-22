package com.nexusnova.lifetravelapi.app.IOT.domain.commands;


import com.nexusnova.lifetravelapi.app.IOT.resources.requests.WeatherSensorRequestDto;

public record UpdateWeatherCommand(Long id, WeatherSensorRequestDto requestDto) {
}
