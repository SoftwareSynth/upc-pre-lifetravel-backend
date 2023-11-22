package com.nexusnova.lifetravelapi.app.core.booking.resources.summaries;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

@Schema(description="Booking (Summary)")
public class BookingSummaryDto {

    @Schema(description="Id del Tour")
    private Long tourPackageId;
    @Schema(description="Titutlo de TourPackage")
    private String tourPackageTitle;
    @Schema(description="Nombre de Agencia")
    private String agencyName;
    @Schema(description="Imagen de Tour Package")
    private String imgUrl;
    @Schema(description="Fecha del Tour")
    private Date tourDate;

    public Long getTourPackageId() {
        return tourPackageId;
    }

    public void setTourPackageId(Long tourPackageId) {
        this.tourPackageId = tourPackageId;
    }

    public String getTourPackageTitle() {
        return tourPackageTitle;
    }

    public void setTourPackageTitle(String tourPackageTitle) {
        this.tourPackageTitle = tourPackageTitle;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Date getTourDate() {
        return tourDate;
    }

    public void setTourDate(Date tourDate) {
        this.tourDate = tourDate;
    }
}
