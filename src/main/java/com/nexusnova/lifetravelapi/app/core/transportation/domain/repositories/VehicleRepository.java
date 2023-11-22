package com.nexusnova.lifetravelapi.app.core.transportation.domain.repositories;

import com.nexusnova.lifetravelapi.app.core.transportation.domain.enums.VehicleStatus;
import com.nexusnova.lifetravelapi.app.core.transportation.domain.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findAllByStatusAndAgencyId(VehicleStatus status, Long agencyId);
}
