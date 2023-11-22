package com.nexusnova.lifetravelapi.app.core.booking.domain.commands;

import com.nexusnova.lifetravelapi.app.core.booking.resources.requests.BookingRequestDto;

public record CreateBookingCommand(BookingRequestDto requestDto) {
}
