package com.nexusnova.lifetravelapi.app.core.transportation.application;

import com.nexusnova.lifetravelapi.app.IAM.profile.domain.model.Agency;
import com.nexusnova.lifetravelapi.app.core.tours.domain.model.TourPackage;
import com.nexusnova.lifetravelapi.app.core.tours.domain.repositories.TourPackageRepository;
import com.nexusnova.lifetravelapi.app.core.transportation.domain.commands.*;
import com.nexusnova.lifetravelapi.app.core.transportation.domain.model.Vehicle;
import com.nexusnova.lifetravelapi.app.core.transportation.domain.repositories.VehicleRepository;
import com.nexusnova.lifetravelapi.app.core.transportation.domain.services.VehicleCommandService;
import com.nexusnova.lifetravelapi.app.core.transportation.resources.requests.VehicleRequestDto;
import com.nexusnova.lifetravelapi.app.shared.ValidationUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleCommandServiceImpl implements VehicleCommandService {
    private final VehicleRepository vehicleRepository;
    private final TourPackageRepository tourPackageRepository;
    private final ValidationUtil validationUtil;

    public VehicleCommandServiceImpl(ValidationUtil validationUtil,
                                     VehicleRepository vehicleRepository,
                                     TourPackageRepository tourPackageRepository) {
        this.validationUtil = validationUtil;
        this.vehicleRepository = vehicleRepository;
        this.tourPackageRepository = tourPackageRepository;
    }

    @Override
    public Vehicle handle(CreateVehicleCommand command) {
        Vehicle vehicle = new Vehicle();
        return setVehicle(vehicle, command.vehicleRequestDto());
    }
    @Override
    public Vehicle handle(ModifyVehicleCommand command) {
        Vehicle vehicle = validationUtil.findVehicleById(command.vehicleId());
        return setVehicle(vehicle, command.vehicleRequestDto());
    }

    @Override
    public Vehicle handle(ModifyImgVehicleCommand command) {
        Vehicle vehicle = validationUtil.findVehicleById(command.vehicleId());
        vehicle.setImg(command.imgUrl());
        vehicleRepository.save(vehicle);
        return vehicle;
    }
    @Override
    public Vehicle handle(AssignVehicleToTourPackageCommand command) {
        Vehicle vehicle = validationUtil.findVehicleById(command.vehicleId());
        TourPackage tourPackage = validationUtil.findTourPackageById(command.tourPackageId());
        List<Vehicle> vehicles = tourPackage.getVehicles();
        vehicles.add(vehicle);
        tourPackage.setVehicles(vehicles);
        tourPackageRepository.save(tourPackage);
        return vehicle;
    }

    @Override
    public Vehicle handle(RemoveVehicleToTourPackageCommand command) {
        Vehicle vehicle = validationUtil.findVehicleById(command.vehicleId());
        TourPackage tourPackage = validationUtil.findTourPackageById(command.tourPackageId());
        List<Vehicle> vehicles = tourPackage.getVehicles();
        vehicles.remove(vehicle);
        tourPackage.setVehicles(vehicles);
        tourPackageRepository.save(tourPackage);
        return vehicle;
    }

    private Vehicle setVehicle(Vehicle vehicle, VehicleRequestDto vehicleRequestDto) {
        Agency agency = validationUtil.findAgencyByUserId(vehicleRequestDto.getAgencyId());
        vehicle.setAgency(agency);
        vehicle.setBrand(vehicleRequestDto.getBrand());
        vehicle.setModel(vehicleRequestDto.getModel());
        vehicle.setPlate(vehicleRequestDto.getPlate());
        vehicle.setCapacity(vehicleRequestDto.getCapacity());
        vehicle.setImg(vehicleRequestDto.getImg());
        vehicle.setDriverName(vehicleRequestDto.getDriverName());
        vehicle.setWeight(vehicleRequestDto.getWeight());
        vehicle.setStatus(vehicleRequestDto.getStatus());
        vehicleRepository.save(vehicle);
        return vehicle;
    }
}
