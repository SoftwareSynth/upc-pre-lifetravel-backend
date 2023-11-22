package com.nexusnova.lifetravelapi.app.IAM.profile.resources.summaries;

import io.swagger.v3.oas.annotations.media.Schema;


@Schema(description="Agency (Summary)")
public class AgencySummaryDto {
    @Schema(description="Id del Usuario")
    private String id;
    @Schema(description="Nombre del Usuario")
    private String legalName;
    @Schema(description="Foto de la agencia")
    private String agencyPhotoUrl;
    @Schema(description="Telefono del Usuario")
    private String phoneNumber;
    @Schema(description="Email del Usuario")
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getAgencyPhotoUrl() {
        return agencyPhotoUrl;
    }

    public void setAgencyPhotoUrl(String agencyPhotoUrl) {
        this.agencyPhotoUrl = agencyPhotoUrl;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}