package com.nexusnova.lifetravelapi.app.IOT.domain.services;

import com.nexusnova.lifetravelapi.app.IOT.domain.commands.UpdateWeatherCommand;

public interface WeatherSensorCommandService {

    void handle(UpdateWeatherCommand command);

}
