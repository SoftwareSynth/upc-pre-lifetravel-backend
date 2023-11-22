package com.nexusnova.lifetravelapi.app.core.tours.application;

import com.nexusnova.lifetravelapi.app.IAM.profile.domain.repositories.AgencyRepository;
import com.nexusnova.lifetravelapi.app.core.tours.domain.model.TourPackage;
import com.nexusnova.lifetravelapi.app.core.tours.domain.queries.*;
import com.nexusnova.lifetravelapi.app.core.tours.domain.repositories.TourPackageRepository;
import com.nexusnova.lifetravelapi.app.core.tours.domain.services.TourPackageQueryService;
import com.nexusnova.lifetravelapi.configuration.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TourPackageQueryServiceImpl implements TourPackageQueryService {
    private final TourPackageRepository tourPackageRepository;
    private final AgencyRepository agencyRepository;
    public TourPackageQueryServiceImpl(TourPackageRepository tourPackageRepository, AgencyRepository agencyRepository) {
        this.tourPackageRepository = tourPackageRepository;
        this.agencyRepository = agencyRepository;
    }

    @Override
    public List<TourPackage> handle() {
        return tourPackageRepository.findAllByVisibleIsTrue();
    }
    @Override
    public List<TourPackage> handle(GetTourPackagesByRegionQuery query) {
        return tourPackageRepository.findByRegionId(query.regionId());
    }
    @Override
    public List<TourPackage> handle(GetTourPackagesByAgencyUserIdQuery query) {
        Long agencyId = agencyRepository.findByUserId(query.userId())
                .orElseThrow(() -> new ResourceNotFoundException("Agency not found with user id: " + query.userId()))
                .getId();
        return tourPackageRepository.findByAgencyId(agencyId);
    }
    @Override
    public List<TourPackage> handle(GetTourPackagesByAgencyIdAndVisibilityQuery query) {
        Long agencyId = agencyRepository.findByUserId(query.userId())
                .orElseThrow(() -> new ResourceNotFoundException("Agency not found with user id: " + query.userId()))
                .getId();
        return tourPackageRepository.findByAgencyIdAndVisible(agencyId, query.visible());
    }

    @Override
    public List<TourPackage> handle(GetTourPackagesByPriceQuery query) {
        BigDecimal minPrice = query.getMinPrice();
        BigDecimal maxPrice = query.getMaxPrice();

        if (minPrice == null || maxPrice == null || minPrice.compareTo(maxPrice) > 0) {
            throw new IllegalArgumentException("Invalid price range");
        }

        return tourPackageRepository.findByPriceBetween(minPrice, maxPrice);
    }

    @Override
    public TourPackage handle(GetTourPackageByIdQuery query) {
        return tourPackageRepository.findById(query.tourPackageId())
                .orElseThrow(() -> new ResourceNotFoundException("TourPackage not found with id: " + query.tourPackageId()));
    }
}