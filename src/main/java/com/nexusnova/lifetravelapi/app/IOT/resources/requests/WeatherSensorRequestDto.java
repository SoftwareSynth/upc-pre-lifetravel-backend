package com.nexusnova.lifetravelapi.app.IOT.resources.requests;

import io.swagger.v3.oas.annotations.media.Schema;


@Schema(description = "Weather Sensor (Request)")
public class WeatherSensorRequestDto {

    @Schema(description = "Temperatura del Sensor")
    private Double temperature;
    @Schema(description = "Humedad del Sensor")
    private Double humidity;

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }
}
