package com.nexusnova.lifetravelapi.app.core.booking.application;

import com.nexusnova.lifetravelapi.app.IAM.profile.domain.model.Tourist;
import com.nexusnova.lifetravelapi.app.core.booking.domain.model.Booking;
import com.nexusnova.lifetravelapi.app.core.booking.domain.queries.GetBookingByPackageAndTouristQuery;
import com.nexusnova.lifetravelapi.app.core.booking.domain.queries.GetUsersByBookingQuery;
import com.nexusnova.lifetravelapi.app.core.booking.domain.queries.GetWeekBookingTouristQuery;
import com.nexusnova.lifetravelapi.app.core.booking.domain.queries.GetWeekBookingAgencyQuery;
import com.nexusnova.lifetravelapi.app.core.booking.domain.repositories.BookingRepository;
import com.nexusnova.lifetravelapi.app.core.booking.domain.services.BookingQueryService;
import com.nexusnova.lifetravelapi.app.shared.ValidationUtil;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.temporal.TemporalAdjusters.nextOrSame;
import static java.time.temporal.TemporalAdjusters.previousOrSame;

@Service
public class BookingQueryServiceImpl implements BookingQueryService {

    private final BookingRepository scheduleRepository;
    private final ValidationUtil validationUtil;

    public BookingQueryServiceImpl(BookingRepository scheduleRepository,
                                   ValidationUtil validationUtil) {
        this.scheduleRepository = scheduleRepository;
        this.validationUtil = validationUtil;
    }

    @Override
    public List<Map<String, Object>> handle(GetWeekBookingTouristQuery query) {
        LocalDate today = LocalDate.now();

        LocalDate monday = today.with(previousOrSame(MONDAY));
        LocalDate sunday = today.with(nextOrSame(SUNDAY));

        Instant startWeek = monday.atStartOfDay(ZoneId.systemDefault()).toInstant();
        Instant endWeek = sunday.atStartOfDay(ZoneId.systemDefault()).toInstant();

        List<Map<String, Object>> bookings = scheduleRepository.findByWeekByTourist(java.util.Date.from(startWeek),
                java.util.Date.from(endWeek), query.touristUserId());

        return bookings;
    }

    @Override
    public List<Map<String, Object>> handle(GetWeekBookingAgencyQuery query) {
        LocalDate today = LocalDate.now();

        LocalDate monday = today.with(previousOrSame(MONDAY));
        LocalDate sunday = today.with(nextOrSame(SUNDAY));

        Instant startWeek = monday.atStartOfDay(ZoneId.systemDefault()).toInstant();
        Instant endWeek = sunday.atStartOfDay(ZoneId.systemDefault()).toInstant();

        List<Map<String, Object>> bookings = scheduleRepository.findByWeekByAgency(java.util.Date.from(startWeek),
                java.util.Date.from(endWeek), query.agencyUserId());

        return bookings;
    }

    @Override
    public Optional<Booking> handle(GetBookingByPackageAndTouristQuery query) {
        return scheduleRepository.findByTouristAndPackage(query.packageId(), query.touristUserId());
    }

    @Override
    public List<Tourist> handle(GetUsersByBookingQuery query) {
        List<String> touristsIds = scheduleRepository.findByTouristAndPackage(query.packageId(), query.tourDate());

        List<Tourist> tourists = new ArrayList<>();
        for (String touristId : touristsIds) {
            Tourist tourist = validationUtil.findTouristByUserId(touristId);
            tourists.add(tourist);
        }
        return tourists;
    }
}
