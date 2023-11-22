package com.nexusnova.lifetravelapi.app.core.transportation.domain.queries;

import com.nexusnova.lifetravelapi.app.core.transportation.domain.enums.VehicleStatus;

public record GetVehiclesByAgencyUserIdAndStatusQuery(String agencyUserId, VehicleStatus status) {
}
