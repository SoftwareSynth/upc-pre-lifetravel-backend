package com.nexusnova.lifetravelapi.app.core.booking.resources.requests;

import com.nexusnova.lifetravelapi.app.core.tours.resources.requests.HourRangeDto;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

@Schema(description="Booking (Request)")
public class BookingRequestDto {

    @Schema(description="Id del Tour Package")
    private Long tourPackageId;
    @Schema(description="Id del Turista User")
    private String touristUserId;
    @Schema(description="Fecha elegida")
    private Date selectedDate;
    @Schema(description="Hour Range")
    private HourRangeDto hourRange;

    public Long getTourPackageId() {
        return tourPackageId;
    }

    public void setTourPackageId(Long tourPackageId) {
        this.tourPackageId = tourPackageId;
    }

    public String getTouristUserId() {
        return touristUserId;
    }

    public void setTouristUserId(String touristUserId) {
        this.touristUserId = touristUserId;
    }

    public Date getSelectedDate() {
        return selectedDate;
    }

    public void setSelectedDate(Date selectedDate) {
        this.selectedDate = selectedDate;
    }

    public HourRangeDto getHourRange() {
        return hourRange;
    }

    public void setHourRange(HourRangeDto hourRange) {
        this.hourRange = hourRange;
    }

}
