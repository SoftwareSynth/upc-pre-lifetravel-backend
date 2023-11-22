package com.nexusnova.lifetravelapi.app.IAM.profile.resources.requests;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

@Schema(description="Tourist (Request)")
public class TouristRequestDto {
    @Schema(description="Nombre del Usuario")
    private String name;
    @Schema(description="Fecha de nacimiento")
    private Date birthDate;
    @Schema(description="Numero de telefono")
    private String phoneNumber;
    @Schema(description="Telefono de emergencia")
    private String emergencyPhoneNumber;
    @Schema(description="Telefono de emergencia")
    private String photoUrl;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmergencyPhoneNumber() {
        return emergencyPhoneNumber;
    }

    public void setEmergencyPhoneNumber(String emergencyPhoneNumber) {
        this.emergencyPhoneNumber = emergencyPhoneNumber;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}