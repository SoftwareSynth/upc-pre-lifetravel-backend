package com.nexusnova.lifetravelapi.app.core.tours.domain.services;

import com.nexusnova.lifetravelapi.app.IAM.profile.domain.repositories.AgencyRepository;
import com.nexusnova.lifetravelapi.app.core.tours.application.TourPackageQueryServiceImpl;
import com.nexusnova.lifetravelapi.app.core.tours.domain.model.TourPackage;
import com.nexusnova.lifetravelapi.app.core.tours.domain.queries.GetTourPackagesByPriceQuery;
import com.nexusnova.lifetravelapi.app.core.tours.domain.repositories.TourPackageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TourPackageQueryServiceTest {

    private TourPackageQueryService tourPackageQueryService;
    private TourPackageRepository tourPackageRepository;

    @BeforeEach
    void setUp() {
        tourPackageRepository = mock(TourPackageRepository.class);
        AgencyRepository agencyRepository = mock(AgencyRepository.class);
        tourPackageQueryService = new TourPackageQueryServiceImpl(tourPackageRepository, agencyRepository);
    }

    @Test
    void handle_WhenValidPriceRange_ExpectFilteredTourPackages() {
        // Arrange
        BigDecimal minPrice = new BigDecimal("100.0");
        BigDecimal maxPrice = new BigDecimal("500.0");
        GetTourPackagesByPriceQuery query = new GetTourPackagesByPriceQuery(minPrice, maxPrice);
        TourPackage tourPackage1 = new TourPackage();
        TourPackage tourPackage2 = new TourPackage();
        List<TourPackage> expectedTourPackages = Arrays.asList(tourPackage1, tourPackage2);

        when(tourPackageRepository.findByPriceBetween(minPrice, maxPrice)).thenReturn(expectedTourPackages);

        // Act
        List<TourPackage> result = tourPackageQueryService.handle(query);

        // Assert
        assertEquals(expectedTourPackages, result);
    }

    @Test
    void handle_WhenInvalidPriceRange_ExpectIllegalArgumentException() {
        // Arrange
        BigDecimal minPrice = new BigDecimal("500.0");
        BigDecimal maxPrice = new BigDecimal("200.0");
        GetTourPackagesByPriceQuery query = new GetTourPackagesByPriceQuery(minPrice, maxPrice);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> tourPackageQueryService.handle(query));
    }

    @Test
    void handle_WhenNullMinPrice_ExpectIllegalArgumentException() {
        // Arrange
        BigDecimal maxPrice = new BigDecimal("500.0");
        GetTourPackagesByPriceQuery query = new GetTourPackagesByPriceQuery(null, maxPrice);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> tourPackageQueryService.handle(query));
    }

    @Test
    void handle_WhenNullMaxPrice_ExpectIllegalArgumentException() {
        // Arrange
        BigDecimal minPrice = new BigDecimal("100.0");
        GetTourPackagesByPriceQuery query = new GetTourPackagesByPriceQuery(minPrice, null);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> tourPackageQueryService.handle(query));
    }

    @Test
    void handle_WhenNullPriceRange_ExpectIllegalArgumentException() {
        // Arrange
        GetTourPackagesByPriceQuery query = new GetTourPackagesByPriceQuery(null, null);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> tourPackageQueryService.handle(query));
    }
}