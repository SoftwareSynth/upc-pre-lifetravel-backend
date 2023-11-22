package com.nexusnova.lifetravelapi.app.IOT.resources.summaries;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(description = "TrackingWereable (Summary)")
public class TrackingWereableSummayDto {

    @Schema(description = "Id del GPS Tracker")
    private Long id;
    @Schema(description = "Nombre")
    private String nombre;
    @Schema(description = "Img")
    private String imgUrl;
    @Schema(description = "Latitud")
    private BigDecimal latitude;
    @Schema(description = "Longitud")
    private BigDecimal longitude;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }
}
