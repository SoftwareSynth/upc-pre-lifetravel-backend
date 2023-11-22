package com.nexusnova.lifetravelapi.app.core.booking.application;

import com.nexusnova.lifetravelapi.app.IAM.identity.domain.model.User;
import com.nexusnova.lifetravelapi.app.IAM.profile.domain.model.Agency;
import com.nexusnova.lifetravelapi.app.core.booking.domain.commands.CreateBookingCommand;
import com.nexusnova.lifetravelapi.app.core.booking.domain.model.Booking;
import com.nexusnova.lifetravelapi.app.core.booking.domain.repositories.BookingRepository;
import com.nexusnova.lifetravelapi.app.core.booking.domain.services.BookingCommandService;
import com.nexusnova.lifetravelapi.app.core.booking.resources.requests.BookingRequestDto;
import com.nexusnova.lifetravelapi.app.core.tours.domain.model.Schedule;
import com.nexusnova.lifetravelapi.app.IAM.profile.domain.model.Tourist;
import com.nexusnova.lifetravelapi.app.core.tours.domain.model.TourPackage;
import com.nexusnova.lifetravelapi.app.core.tours.resources.requests.HourRangeDto;
import com.nexusnova.lifetravelapi.app.core.tours.resources.requests.TimeDto;
import com.nexusnova.lifetravelapi.app.shared.ValidationUtil;
import com.nexusnova.lifetravelapi.app.shared.domain.model.SerieNumber;
import com.nexusnova.lifetravelapi.app.shared.domain.repositories.SerieNumberRepository;
import com.nexusnova.lifetravelapi.app.shared.util.SerieNumberUtil;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static com.nexusnova.lifetravelapi.app.shared.util.CoreConstants.BOOKING_TYPE_SERIE_NUMBER;

@Service
public class BookingCommandServiceImpl implements BookingCommandService {

    private final BookingRepository scheduleRepository;
    private final ValidationUtil validationUtil;
    private final SerieNumberUtil serieNumberUtil;
    private final SerieNumberRepository serieNumberRepository;

    public BookingCommandServiceImpl(BookingRepository scheduleRepository,
                                     ValidationUtil validationUtil,
                                     SerieNumberUtil serieNumberUtil,
                                     SerieNumberRepository serieNumberRepository) {
        this.scheduleRepository = scheduleRepository;
        this.validationUtil = validationUtil;
        this.serieNumberUtil = serieNumberUtil;
        this.serieNumberRepository = serieNumberRepository;
    }

    @Override
    public Booking handle(CreateBookingCommand command) {
        BookingRequestDto requestDto = command.requestDto();

        Booking booking = new Booking();
        TourPackage tourPackage = validationUtil.findTourPackageById(requestDto.getTourPackageId());
        Tourist tourist = validationUtil.findTouristByUserId(requestDto.getTouristUserId());
        User agencyUser = validationUtil.findUserById(tourPackage.getAgency().getUser().getId());
        SerieNumber serieNumber = serieNumberUtil.generateCorrelative(BOOKING_TYPE_SERIE_NUMBER);

        booking.setSerie(serieNumber.getSerie());
        booking.setNumber(serieNumber.getNumber());
        booking.setTourist(tourist);
        booking.setTouristUser(tourist.getUser());
        booking.setTourPackage(tourPackage);
        booking.setAgencyUser(agencyUser);

        booking.setStartDayTime(getDateTime(requestDto.getSelectedDate(), requestDto.getHourRange().getStart()));
        booking.setEndDayTime(getDateTime(requestDto.getSelectedDate(), requestDto.getHourRange().getEnd()));

        serieNumberRepository.save(serieNumber);
        scheduleRepository.save(booking);

        return booking;
    }

    private Date getDateTime(Date date, TimeDto timeDto) {
        String timeString = timeDto.getHour() + ":" + timeDto.getMinute() + " " + timeDto.getDayTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a", Locale.ENGLISH);

        try {
            Date parsedDate = dateFormat.parse(timeString);

            date.setHours(parsedDate.getHours());
            date.setMinutes(parsedDate.getMinutes());

            return date;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
