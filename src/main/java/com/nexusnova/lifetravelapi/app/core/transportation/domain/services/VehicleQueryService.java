package com.nexusnova.lifetravelapi.app.core.transportation.domain.services;

import com.nexusnova.lifetravelapi.app.core.transportation.domain.model.Vehicle;
import com.nexusnova.lifetravelapi.app.core.transportation.domain.queries.GetVehicleByIdQuery;
import com.nexusnova.lifetravelapi.app.core.transportation.domain.queries.GetVehiclesByAgencyUserIdAndStatusQuery;
import com.nexusnova.lifetravelapi.app.core.transportation.domain.queries.GetVehiclesByTourPackageQuery;

import java.util.List;

public interface VehicleQueryService {
    List<Vehicle> handle();
    Vehicle handle(GetVehicleByIdQuery query);
    List<Vehicle> handle(GetVehiclesByAgencyUserIdAndStatusQuery query);
    List<Vehicle> handle(GetVehiclesByTourPackageQuery query);

}
