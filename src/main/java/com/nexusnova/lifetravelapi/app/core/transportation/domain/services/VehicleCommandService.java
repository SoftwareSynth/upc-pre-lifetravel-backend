package com.nexusnova.lifetravelapi.app.core.transportation.domain.services;

import com.nexusnova.lifetravelapi.app.core.transportation.domain.commands.*;
import com.nexusnova.lifetravelapi.app.core.transportation.domain.model.Vehicle;

public interface VehicleCommandService {
    Vehicle handle(CreateVehicleCommand command);
    Vehicle handle(ModifyVehicleCommand command);
    Vehicle handle(ModifyImgVehicleCommand command);
    Vehicle handle(AssignVehicleToTourPackageCommand command);
    Vehicle handle(RemoveVehicleToTourPackageCommand command);
}
