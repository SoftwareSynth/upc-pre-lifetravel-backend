package com.nexusnova.lifetravelapi.app.core.booking.api.transformation;

import com.nexusnova.lifetravelapi.app.core.booking.domain.commands.CreateBookingCommand;
import com.nexusnova.lifetravelapi.app.core.booking.resources.summaries.BookingSummaryDto;
import com.nexusnova.lifetravelapi.app.core.tours.domain.model.TourPackage;
import com.nexusnova.lifetravelapi.app.shared.ValidationUtil;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
public class BookingSummaryAssembler {

    private final ValidationUtil validationUtil;

    public BookingSummaryAssembler(ValidationUtil validationUtil) {
        this.validationUtil = validationUtil;
    }

    public List<BookingSummaryDto> toSummaryFromData(List<Map<String, Object>> bookings) {

        List<BookingSummaryDto> summaries = new ArrayList<>();

        for(Map<String, Object> booking : bookings) {
            BookingSummaryDto summary = new BookingSummaryDto();
            TourPackage tourPackage = validationUtil.findTourPackageById((Long) booking.get("tourPackageId"));

            summary.setTourPackageId(tourPackage.getId());
            summary.setTourPackageTitle(tourPackage.getTitle());
            summary.setAgencyName(tourPackage.getAgency().getLegalName());
            summary.setImgUrl(tourPackage.getImgUrl());
            summary.setTourDate((Date) booking.get("selectedDate"));

            summaries.add(summary);
        }

        return summaries;
    }
}
