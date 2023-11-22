package com.nexusnova.lifetravelapi.app.core.booking.mapper;

import com.nexusnova.lifetravelapi.app.core.booking.domain.model.Booking;
import com.nexusnova.lifetravelapi.app.core.booking.resources.summaries.BookingSummaryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookingMapper {

    @Mappings({
        @Mapping(target = "tourPackageId", source = "tourPackage.id"),
        @Mapping(target = "tourPackageTitle", source = "tourPackage.title"),
        @Mapping(target = "agencyName", source = "tourPackage.agency.legalName"),
        @Mapping(target = "imgUrl", source = "tourPackage.imgUrl"),
        @Mapping(target = "tourDate", source = "startDayTime")
    })
    BookingSummaryDto toSummaryFromData(Booking booking);
}
