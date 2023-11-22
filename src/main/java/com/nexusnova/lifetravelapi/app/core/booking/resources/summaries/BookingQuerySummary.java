package com.nexusnova.lifetravelapi.app.core.booking.resources.summaries;

import java.util.Date;

public class BookingQuerySummary {

    private Long tourPackageId;
    private Date selectedDate;

    public Long getTourPackageId() {
        return tourPackageId;
    }

    public void setTourPackageId(Long tourPackageId) {
        this.tourPackageId = tourPackageId;
    }

    public Date getSelectedDate() {
        return selectedDate;
    }

    public void setSelectedDate(Date selectedDate) {
        this.selectedDate = selectedDate;
    }
}
