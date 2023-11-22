package com.nexusnova.lifetravelapi.app.core.transportation.domain.commands;

import com.nexusnova.lifetravelapi.app.core.transportation.resources.requests.VehicleRequestDto;

public record CreateVehicleCommand(VehicleRequestDto vehicleRequestDto) {
}
