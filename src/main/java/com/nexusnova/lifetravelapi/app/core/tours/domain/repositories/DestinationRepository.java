package com.nexusnova.lifetravelapi.app.core.tours.domain.repositories;

import com.nexusnova.lifetravelapi.app.core.tours.domain.model.Destination;
import com.nexusnova.lifetravelapi.app.core.tours.domain.model.TourPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface DestinationRepository extends JpaRepository<Destination, Long> {
    void deleteByTourPackage(TourPackage tourPackage);
}
