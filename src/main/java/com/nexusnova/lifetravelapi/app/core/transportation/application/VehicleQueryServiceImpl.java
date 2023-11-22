package com.nexusnova.lifetravelapi.app.core.transportation.application;

import com.nexusnova.lifetravelapi.app.IAM.profile.domain.model.Agency;
import com.nexusnova.lifetravelapi.app.core.tours.domain.model.TourPackage;
import com.nexusnova.lifetravelapi.app.core.tours.domain.repositories.TourPackageRepository;
import com.nexusnova.lifetravelapi.app.core.transportation.domain.model.Vehicle;
import com.nexusnova.lifetravelapi.app.core.transportation.domain.queries.GetVehicleByIdQuery;
import com.nexusnova.lifetravelapi.app.core.transportation.domain.queries.GetVehiclesByAgencyUserIdAndStatusQuery;
import com.nexusnova.lifetravelapi.app.core.transportation.domain.queries.GetVehiclesByTourPackageQuery;
import com.nexusnova.lifetravelapi.app.core.transportation.domain.repositories.VehicleRepository;
import com.nexusnova.lifetravelapi.app.core.transportation.domain.services.VehicleQueryService;
import com.nexusnova.lifetravelapi.app.shared.ValidationUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleQueryServiceImpl implements VehicleQueryService {
    private final VehicleRepository vehicleRepository;
    private final TourPackageRepository tourPackageRepository;
    private final ValidationUtil validationUtil;
    public VehicleQueryServiceImpl(VehicleRepository vehicleRepository,
                                   TourPackageRepository tourPackageRepository,
                                   ValidationUtil validationUtil) {
        this.vehicleRepository = vehicleRepository;
        this.tourPackageRepository = tourPackageRepository;
        this.validationUtil = validationUtil;
    }

    @Override
    public List<Vehicle> handle() {
        return vehicleRepository.findAll();
    }
    @Override
    public Vehicle handle(GetVehicleByIdQuery query) {
        return vehicleRepository.findById(query.vehicleId()).orElse(null);
    }
    @Override
    public List<Vehicle> handle(GetVehiclesByAgencyUserIdAndStatusQuery query) {
        Agency agency = validationUtil.findAgencyByUserId(query.agencyUserId());
        return vehicleRepository.findAllByStatusAndAgencyId(query.status(), agency.getId());
    }
    @Override
    public List<Vehicle> handle(GetVehiclesByTourPackageQuery query) {
        TourPackage tourPackage = tourPackageRepository.findById(query.tourPackageId()).orElse(null);
        if (tourPackage != null) {
            return tourPackage.getVehicles();
        }
        return null;
    }
}
