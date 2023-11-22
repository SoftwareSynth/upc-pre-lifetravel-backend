package com.nexusnova.lifetravelapi.app.core.booking.domain.services;

import com.nexusnova.lifetravelapi.app.IAM.profile.domain.model.Tourist;
import com.nexusnova.lifetravelapi.app.core.booking.domain.model.Booking;
import com.nexusnova.lifetravelapi.app.core.booking.domain.queries.GetBookingByPackageAndTouristQuery;
import com.nexusnova.lifetravelapi.app.core.booking.domain.queries.GetUsersByBookingQuery;
import com.nexusnova.lifetravelapi.app.core.booking.domain.queries.GetWeekBookingTouristQuery;
import com.nexusnova.lifetravelapi.app.core.booking.domain.queries.GetWeekBookingAgencyQuery;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface BookingQueryService {

    List<Map<String, Object>> handle(GetWeekBookingTouristQuery query);
    List<Map<String, Object>> handle(GetWeekBookingAgencyQuery query);
    Optional<Booking> handle(GetBookingByPackageAndTouristQuery query);
    List<Tourist> handle(GetUsersByBookingQuery query);
}
