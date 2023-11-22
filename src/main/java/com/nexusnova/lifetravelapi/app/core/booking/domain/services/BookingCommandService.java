package com.nexusnova.lifetravelapi.app.core.booking.domain.services;

import com.nexusnova.lifetravelapi.app.core.booking.domain.commands.CreateBookingCommand;
import com.nexusnova.lifetravelapi.app.core.booking.domain.model.Booking;

public interface BookingCommandService {

    Booking handle(CreateBookingCommand command);
}
