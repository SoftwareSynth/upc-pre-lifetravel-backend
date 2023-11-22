package com.nexusnova.lifetravelapi.app.IOT.resources.summaries;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.util.List;

@Schema(name = "Weather (Summary)")
public class WeatherSummaryDto {

    @Schema(description = "Temperatura")
    private Double temperature;
    @Schema(description = "Humedad")
    private Double humidity;
    @Schema(description = "Ropas")
    private List<String> clothes;
    @Schema(description = "Objetos")
    private List<String> objects;

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

    public List<String> getClothes() {
        return clothes;
    }

    public void setClothes(List<String> clothes) {
        this.clothes = clothes;
    }

    public List<String> getObjects() {
        return objects;
    }

    public void setObjects(List<String> objects) {
        this.objects = objects;
    }
}
