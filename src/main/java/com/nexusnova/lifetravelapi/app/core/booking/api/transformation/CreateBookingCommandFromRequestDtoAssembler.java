package com.nexusnova.lifetravelapi.app.core.booking.api.transformation;

import com.nexusnova.lifetravelapi.app.core.booking.domain.commands.CreateBookingCommand;
import com.nexusnova.lifetravelapi.app.core.booking.resources.requests.BookingRequestDto;

public class CreateBookingCommandFromRequestDtoAssembler {
    public static CreateBookingCommand toCommandFromDto(BookingRequestDto requestDto) {
        return new CreateBookingCommand(requestDto);
    }
}