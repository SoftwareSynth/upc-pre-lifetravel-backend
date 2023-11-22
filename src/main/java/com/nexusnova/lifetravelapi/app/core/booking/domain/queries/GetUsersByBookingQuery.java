package com.nexusnova.lifetravelapi.app.core.booking.domain.queries;

import java.util.Date;

public record GetUsersByBookingQuery(Long packageId, Date tourDate) {
}
